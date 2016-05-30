package be.vdab.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;

@Repository
class BrouwerRepositoryImpl implements BrouwerRepository {
	
	private final JdbcTemplate jdbcTemplate;
	private final SimpleJdbcInsert simpleJdbcInsert;
	private final BrouwerRowMapper rowMapper = new BrouwerRowMapper();
	
	// JDBC SQL STATEMENTS
	private static final String BEGIN_SELECT =
			"select id,naam,postcode,gemeente,straat,huisnr,omzet from brouwers ";
	private static final String SQL_FIND_ALL = BEGIN_SELECT + "order by naam";
	private static final String SQL_FIND_BY_NAAM =
			BEGIN_SELECT + "where naam like ? order by naam";
	
	// CONSTRUCTOR
	@Autowired
	BrouwerRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.setTableName("brouwers");
		simpleJdbcInsert.usingGeneratedKeyColumns("id");
	}

	@Override
	public void create(Brouwer brouwer) {
		Map<String, Object> kolomWaarden = new HashMap<>();
		kolomWaarden.put("naam", brouwer.getNaam());
		kolomWaarden.put("postcode", brouwer.getAdres().getPostcode());
		kolomWaarden.put("gemeente", brouwer.getAdres().getGemeente());
		kolomWaarden.put("omzet", brouwer.getOmzet());
		kolomWaarden.put("straat", brouwer.getAdres().getStraat());
		kolomWaarden.put("huisnr", brouwer.getAdres().getHuisNr());
		brouwer.setId(
		simpleJdbcInsert.executeAndReturnKey(kolomWaarden).longValue());
	}

	@Override
	public List<Brouwer> findAll() {
		return jdbcTemplate.query(SQL_FIND_ALL, rowMapper);
	}

	@Override
	public List<Brouwer> findByEersteLetter(String eersteLetter) {
		return jdbcTemplate.query(SQL_FIND_BY_NAAM, rowMapper, eersteLetter + '%');
	}

	private static class BrouwerRowMapper implements RowMapper<Brouwer> {

		@Override
		public Brouwer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			return new Brouwer(resultSet.getLong("id"), resultSet.getString("naam"),
					new Adres(resultSet.getString("straat"), resultSet.getString("huisnr"),
					resultSet.getInt("postcode"), resultSet.getString("gemeente")),
					(Integer) resultSet.getObject("omzet"));
		}
		
	}
	
}
