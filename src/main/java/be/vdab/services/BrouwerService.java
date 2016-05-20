package be.vdab.services;

import java.util.List;

import be.vdab.entities.Brouwer;

public interface BrouwerService {
	
	void create(Brouwer Brouwer);
	List<Brouwer> findAll();
	List<Brouwer> findByNaam(String zoekstring);

}
