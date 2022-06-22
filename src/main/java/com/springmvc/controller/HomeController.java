package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.entity.Country;
import com.springmvc.service.CountryService;

@Controller
public class HomeController {
	@Autowired
	CountryService countryService;
	
	@RequestMapping("/") 
	public String welcome(Model model)
	{	
		model.addAttribute("message1", "hello, I am the controller");
		return "index";
	}
	
	@RequestMapping("/new")
	public String showCountryForm(Model model)
	{
		Country c = new Country();
		model.addAttribute(c);
		return "new_country";
	}
	
	@RequestMapping("/list_countries") 
	public String listCountries(Model model)
	{
		List<Country> listCountry = countryService.getList();
		model.addAttribute("countries",listCountry); 	
		return "countries";
	}
	/*@RequestMapping("/list_countries") 
	public String listCountries(Model model)
	{
		List<String> listCountry = countryService.getNameList();
		model.addAttribute("countries",listCountry); 	
		return "countries";
	}*/
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String saveEmp(@ModelAttribute("country") Country country)
	{
		/* System.out.println(emp.getCountry());
		System.out.println(emp.getEmail());
		System.out.println(emp.getName()); */
		countryService.save(country);
		return "redirect:/list_countries";
	}
	@RequestMapping("/edit/{countryID}")
	public ModelAndView showEditCountryPage(@PathVariable(name="countryID") int countryID)
	{
		ModelAndView mav = new ModelAndView("edit_country");
		Country c = countryService.get(countryID);
		mav.addObject("country",c);
		return mav;
		
		
	}
	@RequestMapping("/delete/{countryID}")
	public String deleteCountry(@PathVariable(name="countryID") int countryID)
	{
		countryService.delete(countryID);
		return "redirect:/list_countries";
		
	}
	
}
