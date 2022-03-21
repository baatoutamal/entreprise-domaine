package com.esprit.microservice.service;


import java.util.List;

import com.esprit.microservice.entity.Domaine;



public interface DomaineService {
	
	Domaine addDoamine(Domaine domaine);
	
	boolean deleteDoamine(int id);
	
	List<Domaine> ListDoamines();
	
	Domaine updateDoamine(Domaine domaine);
	
	
}