package com.baha.vetements.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.baha.vetements.entities.Vetement;
import com.baha.vetements.repos.VetementRepository;

@Service
public class VetementServiceImpl implements VetementService {

    private final VetementRepository vetementRepository;

    @Autowired
    public VetementServiceImpl(VetementRepository vetementRepository) {
        this.vetementRepository = vetementRepository;
    }

    @Override
    public Vetement saveVetement(Vetement p) {
        return vetementRepository.save(p);
    }

    @Override
    public Vetement updateVetement(Vetement p) {
        return vetementRepository.save(p);
    }

    @Override
    public void deleteVetement(Vetement p) {
        vetementRepository.delete(p);        
    }

    @Override
    public void deleteVetementById(Long id) {
        vetementRepository.deleteById(id);        
    }

    @Override
    public Vetement getVetement(Long id) {
        return vetementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vetement> getAllVetements() {
        return vetementRepository.findAll();
    }

	@Override
	public Page<Vetement> getAllVetementsParPage(int page, int size) {
		return vetementRepository.findAll(PageRequest.of(page, size));
	}
}
