package com.baha.vetements.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baha.vetements.entities.Vetement;

public interface VetementRepository extends JpaRepository<Vetement, Long> {

}
