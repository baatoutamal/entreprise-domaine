package com.esprit.microservice.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.esprit.microservice.entity.Domaine;
import com.esprit.microservice.repository.DomaineRepository;
import com.esprit.microservice.service.DomaineService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomaineServiceImpl implements DomaineService {
    @Autowired
    private DomaineRepository domaineRepository;

	@Override
	public Domaine addDoamine(Domaine domaine) {
		return domaineRepository.save(domaine);
	}

	@Override
	public boolean deleteDoamine(int id) {
		Boolean test_domaine = domaineRepository.existsById(id);
		if (test_domaine) {
			domaineRepository.deleteById(id);
			return true;
		}
		return false;
		 
	}

	@Override
	public List<Domaine> ListDoamines() {
		List<Domaine> listDomaines = (List<Domaine>) domaineRepository.findAll();
		return listDomaines;
		
	}

	@Override
	public Domaine updateDoamine(Domaine domaine) {
		Boolean test_domaine = domaineRepository.existsById(domaine.getId());
		if (test_domaine) {
		return domaineRepository.save(domaine);
		}
		return null;
	}



	
	
	

}