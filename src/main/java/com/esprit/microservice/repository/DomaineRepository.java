package com.esprit.microservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.esprit.microservice.entity.Domaine;


public interface DomaineRepository extends CrudRepository<Domaine, Integer> {
	Domaine findById(int id);
    
}
