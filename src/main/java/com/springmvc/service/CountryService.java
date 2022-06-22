package com.springmvc.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.entity.*;
import com.springmvc.repo.CountryRepo;


@Service
public class CountryService {
	@Autowired
	CountryRepo countryRepo;
	public List<Country> getList()
	{
	
		List<Country> list=countryRepo.findAll();
		return list;
		
	}
	public List<String> getNameList()
	{
	
		List<Country> list=countryRepo.findAll();
		List<String> cl = new ArrayList<String>();
		for (Country c : list) {
			cl.add(c.getCountryName());
		}
		return cl;
		
	}
	public void save(Country e)
	{
		countryRepo.save(e);
	}
	public Country get(int countryID)
	{
		return countryRepo.findById(countryID).get();
	}
	public void delete(int countryID)
	{
		countryRepo.deleteById(countryID);
	}
}
