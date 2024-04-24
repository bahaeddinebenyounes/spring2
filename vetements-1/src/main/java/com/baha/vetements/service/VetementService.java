package com.baha.vetements.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.baha.vetements.entities.Vetement;

public interface VetementService {
	Vetement saveVetement(Vetement p);
	Vetement updateVetement(Vetement p);
	void deleteVetement(Vetement p);
	void deleteVetementById(Long id);
	Vetement getVetement(Long id);
	List<Vetement> getAllVetements();
	Page<Vetement> getAllVetementsParPage(int page, int size);
}
