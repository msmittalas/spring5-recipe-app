package io.mitts.springdemo.recipedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mitts.springdemo.recipedemo.repository.CategoryRepository;
import io.mitts.springdemo.recipedemo.repository.UOMRepository;

@RestController
public class IndexController {

	@Autowired
	CategoryRepository repo;
	@Autowired
	UOMRepository uomRepo;
	
	
	@GetMapping(value = {"","/","/index.html"})
	public String getIndexPage()
	{
		System.out.println("Category Id : "+repo.findByDescription("Italian").get().getId());
		return "index";
	}
	
	
	
}
