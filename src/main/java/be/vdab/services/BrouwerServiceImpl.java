package be.vdab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.vdab.entities.Brouwer;
import be.vdab.repositories.BrouwerRepository;

@Service
class BrouwerServiceImpl implements BrouwerService {

	private final BrouwerRepository brouwerRepository;
	
	@Autowired
	BrouwerServiceImpl(BrouwerRepository brouwerRepository) {
		this.brouwerRepository = brouwerRepository;
	}
	
	@Override
	public void create(Brouwer brouwer) {
		brouwerRepository.create(brouwer);
	}

	@Override
	public List<Brouwer> findAll() {
		return brouwerRepository.findAll();
	}

	@Override
	public List<Brouwer> findByNaam(String zoekstring) {
		return brouwerRepository.findByNaam(zoekstring);
	}
	
	

}
