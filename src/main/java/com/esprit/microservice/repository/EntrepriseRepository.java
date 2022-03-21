package com.esprit.microservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.esprit.microservice.entity.Entreprise;


public interface EntrepriseRepository extends CrudRepository<Entreprise, Integer> {
	Entreprise findById(int id);
	
}
