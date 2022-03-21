package com.esprit.microservice.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Domaine implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	
	
	@JsonManagedReference("domaine")
	@OneToMany(mappedBy= "domaine")
    private List<EntrepriseDomaine> entrepriseDomaines;

	
	public List<EntrepriseDomaine> getEntrepriseDomaines() {
		return entrepriseDomaines;
	}

	public void setEntrepriseDomaines(List<EntrepriseDomaine> entrepriseDomaines) {
		this.entrepriseDomaines = entrepriseDomaines;
	}


	public Domaine() {
        super();
    }

	public Domaine(String name, String description) {
        this.name = name;
        this.description = description;
    }

	public String getDescription() {
		return description;
	}

    public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}