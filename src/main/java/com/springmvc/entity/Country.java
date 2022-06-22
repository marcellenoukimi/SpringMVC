package com.springmvc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Countries")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int countryID;
	
	public int getCountryID() {
		return countryID;
	}
	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}
	public Country(int countryID, String countryName, String capitalName, String population) {
		
		this.countryID = countryID;
		this.countryName = countryName;
		this.capitalName = capitalName;
		this.population = population;
	}
	String countryName;
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	String capitalName;
	String population;
	public Country() {
		
	}

	
	public String getCapitalName() {
		return capitalName;
	}
	public void setCapitalName(String capitalName) {
		this.capitalName = capitalName;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	
}
