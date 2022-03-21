package com.esprit.microservice.service;


import java.io.InputStream;
import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;
import com.esprit.microservice.entity.Entreprise;
import com.esprit.microservice.entity.EntrpriseDomaineObject;


public interface EntrepriseService {
	List<Entreprise> listEntreprisesByDomaine(int idDomaine);
	Entreprise registerEntreprise(EntrpriseDomaineObject entreprise);
	Entreprise updateEntreprise(EntrpriseDomaineObject entreprise);
	boolean deleteEntreprise(int id);
	
}