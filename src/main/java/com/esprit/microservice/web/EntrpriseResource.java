package com.esprit.microservice.web;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.microservice.entity.Entreprise;
import com.esprit.microservice.entity.EntrpriseDomaineObject;
import com.esprit.microservice.service.impl.EntrepriseServiceImpl;



@RestController
@RequestMapping("api/entreprise")
public class EntrpriseResource {

	
	 @Autowired
   private EntrepriseServiceImpl entrepriseServiceImpl;

    
    
    @GetMapping("listEntreprisesByDomaine/{idDomaine}")
    public ResponseEntity<?> listEntreprisesByDomaine(@PathVariable  int idDomaine) {
    	
    	List<Entreprise> listEntreprisesByDomaine = entrepriseServiceImpl.listEntreprisesByDomaine(idDomaine);
    	
    	if(listEntreprisesByDomaine == null){
    		
    		return new ResponseEntity<>(new DataResult("Domaine is not found",true,null), HttpStatus.NOT_FOUND);
    	}
    	 
    	 return new ResponseEntity<>(new DataResult("List entreprises by domaine",true,listEntreprisesByDomaine), HttpStatus.OK);
    	 
       
    }
    
    @PostMapping(value="registerEntreprise",consumes = MediaType.APPLICATION_JSON_VALUE, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> registerEntreprise(@RequestBody EntrpriseDomaineObject entrepriseObj) {
    	Entreprise entreprise =  entrepriseServiceImpl.registerEntreprise(entrepriseObj);
        if (entreprise!=null)
        {
        return new ResponseEntity<>(new DataResult("Registered entreprise",true,entreprise), HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<>(new DataResult("Entreprise aleready exist",true,null), HttpStatus.FOUND);
        }
    }	
    @DeleteMapping("deleteEntreprise/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteEntreprise(@PathVariable int id) {
        boolean entreprise = entrepriseServiceImpl.deleteEntreprise(id);
        if (entreprise)
        {
        	
        	return new ResponseEntity<>(new DataResult("Entreprise deleted",true,entreprise), HttpStatus.OK);
        	}
        else {
        	return new ResponseEntity<>(new DataResult("Entreprise is not found",true,null), HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("updateEntreprise")
    @ResponseBody
    public ResponseEntity<?> updateDomaine(@RequestBody EntrpriseDomaineObject entrepriseobj) {
    	Entreprise entreprise =  entrepriseServiceImpl.updateEntreprise(entrepriseobj);
        if (entreprise!=null)
        {
        return new ResponseEntity<>(new DataResult("Entreprise updated",true,entreprise), HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<>(new DataResult("Entreprise not found",true,null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
  
}