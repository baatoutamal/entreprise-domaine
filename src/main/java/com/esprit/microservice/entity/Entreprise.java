package com.esprit.microservice.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.*;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class Entreprise extends User implements Serializable {
   
	private String address;

	
	@JsonManagedReference("entreprise")
    @OneToMany(mappedBy= "entreprise",fetch=FetchType.LAZY)
    private List<EntrepriseDomaine> entrepriseDomaines = new ArrayList<EntrepriseDomaine>();
    
    private String name;

    private String socialRegister;
  
    
    public Entreprise() {
        super();
    }

	public Entreprise(int id, String username, String password, String email, String name, String socialRegister, String address) {
        super(id, username, password, email);
        this.name = name;
        this.socialRegister = socialRegister;
        this.address = address;
    }

	public Entreprise(String name, String socialRegister, String address) {
        this.name = name;
        this.socialRegister = socialRegister;
        this.address = address;
    }

	public String getAddress() {
        return address;
    }


	public List<EntrepriseDomaine> getEntrepriseDomaines() {
		return entrepriseDomaines;
	}

    public String getName() {
        return name;
    }

    public String getSocialRegister() {
        return socialRegister;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void setEntrepriseDomaines(List<EntrepriseDomaine> entrepriseDomaines) {
		this.entrepriseDomaines = entrepriseDomaines;
	}

    public void setName(String name) {
        this.name = name;
    }

    public void setSocialRegister(String socialRegister) {
        this.socialRegister = socialRegister;
    }
}