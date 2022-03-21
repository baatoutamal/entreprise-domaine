package com.esprit.microservice.entity;

import java.util.List;

public class EntrpriseDomaineObject {
	List<Integer> domainesInterested;
	List<Integer> domainesRelated;
	Entreprise  entreprise;
	public List<Integer> getDomainesInterested() {
		return domainesInterested;
	}
	public List<Integer> getDomainesRelated() {
		return domainesRelated;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setDomainesInterested(List<Integer> domainesInterested) {
		this.domainesInterested = domainesInterested;
	}
	public void setDomainesRelated(List<Integer> domainesRelated) {
		this.domainesRelated = domainesRelated;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	
	
	
}

