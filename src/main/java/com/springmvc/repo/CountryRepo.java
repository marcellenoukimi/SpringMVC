package com.springmvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.entity.Country;


@Repository
public interface CountryRepo extends JpaRepository<Country, Integer>{
	
}
