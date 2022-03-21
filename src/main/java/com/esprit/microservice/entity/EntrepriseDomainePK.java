package com.esprit.microservice.entity;


import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Embeddable
public class EntrepriseDomainePK implements Serializable {


    @Column(name="domaine_id")
	private int domaineId;
    @Column(name="entrpeise_id")
	private int entrpeiseId;
    
	public EntrepriseDomainePK() {
		super();
	}
	public EntrepriseDomainePK(int entrpeiseId, int domaineId) {
		super();
		this.entrpeiseId = entrpeiseId;
		this.domaineId = domaineId;
	}
	public int getDomaineId() {
		return domaineId;
	}
	public int getEntrpeiseId() {
		return entrpeiseId;
	}
	public void setDomaineId(int domaineId) {
		this.domaineId = domaineId;
	}
	public void setEntrpeiseId(int entrpeiseId) {
		this.entrpeiseId = entrpeiseId;
	}

   
    

}
