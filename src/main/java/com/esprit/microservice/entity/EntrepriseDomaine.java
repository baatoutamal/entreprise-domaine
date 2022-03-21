package com.esprit.microservice.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class EntrepriseDomaine implements Serializable {
	

	@EmbeddedId
    private EntrepriseDomainePK EntrepriseDomainePK; 

	@JsonBackReference("domaine")
	@ManyToOne
	@JoinColumn(name="domaine_id", referencedColumnName="id", insertable =false, updatable = false)
	private Domaine domaine;
	
   @JsonBackReference("entreprise")
	@ManyToOne
	@JoinColumn(name="entrpeise_id", referencedColumnName="id", insertable =false, updatable = false)
	private Entreprise entreprise;

	private String type;
	
	public EntrepriseDomaine() {
   	 super();
   }
    public EntrepriseDomaine(Domaine domaine, Entreprise entreprise, String type) {
		super();
		this.domaine = domaine;
		this.entreprise = entreprise;
		this.type = type;
	}
    
    
	public EntrepriseDomaine(String type) {
		super();
		this.type = type;
	}
	public Domaine getDomaine() {
		return domaine;
	}


	public EntrepriseDomainePK getEntrepriseDomainePK() {
		return EntrepriseDomainePK;
	}
	public String getType() {
		return type;
	}
	


	public void setEnreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	
	public void setEntrepriseDomainePK(EntrepriseDomainePK entrepriseDomainePK) {
		EntrepriseDomainePK = entrepriseDomainePK;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	


   
    

}