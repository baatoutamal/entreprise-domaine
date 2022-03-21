package com.esprit.microservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.esprit.microservice.entity.EntrepriseDomaine;


public interface EntrepriseDomaineRepository extends CrudRepository<EntrepriseDomaine, Integer> {
	
    
}
