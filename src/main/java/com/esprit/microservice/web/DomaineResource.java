package com.esprit.microservice.web;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservice.entity.Domaine;
import com.esprit.microservice.service.impl.DomaineServiceImpl;




@RestController
@RequestMapping("api/domaine")
public class DomaineResource {
   
    @Autowired
    private DomaineServiceImpl domaineServiceImpl;
    
       
    @PostMapping("addDomaine")
    @ResponseBody
    public ResponseEntity<?> addDomaine(@RequestBody Domaine domaine) {
        domaine =  domaineServiceImpl.addDoamine(domaine);
        if (domaine!=null)
        {
        return new ResponseEntity<>(new DataResult("Add Domaine",true,domaine), HttpStatus.OK);
        
        }
        else {
        	
        	return new ResponseEntity<>(new DataResult("Somthing went wrong, try again",true,null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("deleteDomaine/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteDoamine(@PathVariable int id) {
        boolean domaine = domaineServiceImpl.deleteDoamine(id);
        if (domaine)
        {return  ResponseEntity.ok(new DataResult("Domaine deleted",true,domaine));}
        else {
        	return new ResponseEntity<>(new DataResult("Somthing went wrong, try again",true,null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("listDoamines")
    public ResponseEntity<?> listDoamines() {
    	 return  ResponseEntity.ok(new DataResult("Domaines",true,domaineServiceImpl.ListDoamines()));	
    
    }

    
    @PostMapping("updateDomaine")
    @ResponseBody
    public ResponseEntity<?> updateDomaine(@RequestBody Domaine domaine) {
        domaine =  domaineServiceImpl.updateDoamine(domaine);
        if (domaine!=null)
        {
        return new ResponseEntity<>(new DataResult("Domaine updated",true,domaine), HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<>(new DataResult("Domaine not found",true,null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}