package be.vdab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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
		brouwerRepository.create(brouwer);
	}

	@Override
	public List<Brouwer> findAll() {
		return brouwerRepository.findAll();
	}

	@Override
	public List<Brouwer> findByEersteLetter(String eersteLetter) {
		return brouwerRepository.findByEersteLetter(eersteLetter);
	}

}
