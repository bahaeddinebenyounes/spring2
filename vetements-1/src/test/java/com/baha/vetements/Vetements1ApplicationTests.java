package com.baha.vetements;

import java.util.Date;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.baha.vetements.entities.Vetement;
import com.baha.vetements.repos.VetementRepository;
import com.baha.vetements.service.VetementService;

@SpringBootTest
class Vetements1ApplicationTests {

	@Autowired
	private VetementRepository vetementRepository;
	private VetementService vetementService;
	@Test
	public void testCreateVetement() {
	Vetement vet = new Vetement("chaussure Nike",200.123,new Date());
	vetementRepository.save(vet);
	}
	
	@Test
	public void testFindVetement()
	{ Vetement p =vetementRepository.findById(1L).get();
	System.out.println(p);
	}
	@Test
	public void testUpdateVetement()
	{ Vetement p = vetementRepository.findById(6L).get();
	p.setPrixVetement(1000.0); vetementRepository.save(p);
	}
	@Test
	public void testDeleteVetement()
	{ vetementRepository.deleteById(9L);
	}
	
	@Test
	public void testListerTousVetements()
	{
	List<Vetement> vets = vetementRepository.findAll();
	for (Vetement p : vets)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testFindByNomProduitContains()
	{
	Page<Vetement> prods = vetementService.getAllVetementsParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements()); System.out.println(prods.getTotalPages());
	prods.getContent().forEach(p -> {System.out.println(p.toString());
	});}
}