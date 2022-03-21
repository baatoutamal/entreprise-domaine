package com.esprit.microservice.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.microservice.entity.Domaine;
import com.esprit.microservice.entity.Entreprise;
import com.esprit.microservice.entity.EntrepriseDomaine;
import com.esprit.microservice.entity.EntrepriseDomainePK;
import com.esprit.microservice.entity.EntrpriseDomaineObject;

import com.esprit.microservice.entity.User;
import com.esprit.microservice.repository.DomaineRepository;
import com.esprit.microservice.repository.EntrepriseDomaineRepository;
import com.esprit.microservice.repository.EntrepriseRepository;
import com.esprit.microservice.repository.UserRepository;
import com.esprit.microservice.service.EntrepriseService;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.PasswordAuthentication;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {
	
    @Autowired
    private DomaineRepository domaineRepository;
    
    @Autowired
    private EntrepriseDomaineRepository entrepriseDomaineRepository;
 
    
    @Autowired
    private EntrepriseRepository entrepriseRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    
    @Autowired
	private JavaMailSender sender;
	
    @Autowired
	private Configuration config;
	
	@Override
	public List<Entreprise> listEntreprisesByDomaine(int idDomaine) {
		Domaine domaine = domaineRepository.findById(idDomaine);
		
		if(domaine !=null){
			

			if(domaine.getEntrepriseDomaines()!=null)return domaine.getEntrepriseDomaines().stream().map(x -> x.getEntreprise()).collect(Collectors.toList());
					
		}
		return null;
	}

	@Override
	public Entreprise registerEntreprise(EntrpriseDomaineObject entrepriseObj) {
		User user = userRepository.findByUsername(entrepriseObj.getEntreprise().getUsername());
		if (user != null ) {
			return null;
		}
		Entreprise entreprise =  entrepriseRepository.save(entrepriseObj.getEntreprise());
		if(entreprise!= null) {
			List<Integer> domainesInterested = entrepriseObj.getDomainesInterested();
			List<EntrepriseDomaine> listEntrepriseDomaine = new ArrayList();

			for( Integer domaineId: domainesInterested) {
				Domaine domaine = domaineRepository.findById(domaineId).get();
				if (domaine != null) {
					EntrepriseDomaine entrpDomaine = new EntrepriseDomaine(domaine,entreprise,"Interested");
					entrpDomaine.setEntrepriseDomainePK(new EntrepriseDomainePK(entreprise.getId(),domaineId));
					listEntrepriseDomaine.add(entrpDomaine);
					entreprise.setEntrepriseDomaines(listEntrepriseDomaine);
					entrepriseDomaineRepository.save(entrpDomaine);
				}
				
			}
			List<Integer> domainesRelated= entrepriseObj.getDomainesRelated();
			for( Integer domaineId: domainesRelated) {
				Domaine domaine = domaineRepository.findById(domaineId).get();
				if (domaine != null) {
					EntrepriseDomaine entrpDomaine = new EntrepriseDomaine(domaine,entreprise,"Related");
					entrpDomaine.setEntrepriseDomainePK(new EntrepriseDomainePK(entreprise.getId(),domaineId));
					listEntrepriseDomaine.add(entrpDomaine);
					entreprise.setEntrepriseDomaines(listEntrepriseDomaine);
					entrepriseDomaineRepository.save(entrpDomaine);
				}
				
			}

			return entreprise;
		}
		
		return null;
		
	}
	 
	@Override
	public Entreprise updateEntreprise(EntrpriseDomaineObject entrepriseObj) {
		Boolean test_entreprise = entrepriseRepository.existsById(entrepriseObj.getEntreprise().getId());
		if (test_entreprise) {
		Entreprise entreprise =  entrepriseRepository.save(entrepriseObj.getEntreprise());
		if(entreprise!= null) {
			List<Integer> domainesInterested = entrepriseObj.getDomainesInterested();
			List<EntrepriseDomaine> listEntrepriseDomaine = new ArrayList();

			for( Integer domaineId: domainesInterested) {
				Domaine domaine = domaineRepository.findById(domaineId).get();
				if (domaine != null) {
					EntrepriseDomaine entrpDomaine = new EntrepriseDomaine(domaine,entreprise,"Interested");
					entrpDomaine.setEntrepriseDomainePK(new EntrepriseDomainePK(entreprise.getId(),domaineId));
					listEntrepriseDomaine.add(entrpDomaine);
					entreprise.setEntrepriseDomaines(listEntrepriseDomaine);
					entrepriseDomaineRepository.save(entrpDomaine);
				}
				
			}
			List<Integer> domainesRelated= entrepriseObj.getDomainesRelated();
			for( Integer domaineId: domainesRelated) {
				Domaine domaine = domaineRepository.findById(domaineId).get();
				if (domaine != null) {
					EntrepriseDomaine entrpDomaine = new EntrepriseDomaine(domaine,entreprise,"Related");
					entrpDomaine.setEntrepriseDomainePK(new EntrepriseDomainePK(entreprise.getId(),domaineId));
					listEntrepriseDomaine.add(entrpDomaine);
					entreprise.setEntrepriseDomaines(listEntrepriseDomaine);
					entrepriseDomaineRepository.save(entrpDomaine);
				}
				
			}

			return entreprise;
		}
		}
		return null;
	}

	@Override
	public boolean deleteEntreprise(int id) {
		Boolean test_entreprise = entrepriseRepository.existsById(id);
		if (test_entreprise) {
			entrepriseRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	

}