package be.vdab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import be.vdab.entities.Brouwer;
import be.vdab.repositories.BrouwerRepository;

@EnableTransactionManagement
@ReadOnlyTransactionalService
class BrouwerServiceImpl implements BrouwerService {

	private final BrouwerRepository brouwerRepository;
	
	@Autowired
	BrouwerServiceImpl(BrouwerRepository brouwerRepository) {
		this.brouwerRepository = brouwerRepository;
	}
	
	@Override
	@ModifyingTransactionalServiceMethod
	public void create(Brouwer brouwer) {
		brouwerRepository.save(brouwer);
	}

	@Override
	public List<Brouwer> findAll() {
		return brouwerRepository.findAll(new Sort("naam"));
	}

	@Override
	public List<Brouwer> findByEersteLetter(String eersteLetter) {
		return brouwerRepository.findByNaamStartsWithOrderByNaamAsc(eersteLetter);
	}

}
