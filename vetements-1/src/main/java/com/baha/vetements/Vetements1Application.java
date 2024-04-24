package com.baha.vetements;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.baha.vetements.entities.Vetement;
import com.baha.vetements.service.VetementService;

@SpringBootApplication
public class Vetements1Application implements CommandLineRunner{
	
	@Autowired
	VetementService vetementService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Vetements1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		vetementService.saveVetement(new Vetement("aa", 2600.0, new Date()));
		vetementService.saveVetement(new Vetement("bb", 2800.0, new Date()));
		vetementService.saveVetement(new Vetement("cc", 900.0, new Date()));
	}

}
