package be.vdab.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;

@Repository
class BrouwerRepositoryImpl implements BrouwerRepository {
	
	private final Map<Long, Brouwer> brouwers = new ConcurrentHashMap<>();

	BrouwerRepositoryImpl() {
		brouwers.put(1L, new Brouwer(1L, "Palm", new Adres("Palmstraat", "4", "1000", "Steenhuffel"), 5_000_000));
		brouwers.put(2L, new Brouwer(2L, "De Koninck", new Adres("Ergens in A'pen", "3", "2000", "Antwerpen"), 1_000_000));
		brouwers.put(3L, new Brouwer(3L, "AB InBev", new Adres("Ergens in Leuven ofzo", "2", "W/E", "Leuven"), 500_000));
		brouwers.put(4L, new Brouwer(4L, "Heineken", new Adres("Pisstraat", "1", "13000", "Kaasdorp"), 5_000));
	}

	@Override
	public void create(Brouwer brouwer) {
		brouwers.put(brouwer.getId(), brouwer);
	}

	@Override
	public List<Brouwer> findAll() {
		return new ArrayList<>(brouwers.values());
	}

	@Override
	public List<Brouwer> findByNaam(String zoekstring) {
		List<Brouwer> gevondenBrouwers = new ArrayList<>();
		
		for (Brouwer brouwer : brouwers.values()) {
			if (brouwer.getNaam().contains(zoekstring)) {
				gevondenBrouwers.add(brouwer);
			}
		}
		
		return gevondenBrouwers;
	}

}
