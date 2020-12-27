package io.mitts.springdemo.recipedemo.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import io.mitts.springdemo.recipedemo.command.CategoryCommand;
import io.mitts.springdemo.recipedemo.exception.DataNotFoundException;
import io.mitts.springdemo.recipedemo.service.CategoryService;

@Controller
@RequestMapping("/category/")
public class CategoryController {

	CategoryService service;
	
	public CategoryController(CategoryService service) {
		this.service=service;
	}
	@GetMapping("/get/{id}")
	public String getCategory(@PathVariable Long id,Model model) 
	{
		
		model.addAttribute("category",service.findOne(id));
		return "showcategory";
	}
	
	
	
	
	@GetMapping
	public String getAllCategories(Model model)
	{
		model.addAttribute("categories", service.getAllCategory());
		model.addAttribute("category", new CategoryCommand());
		
		return "categoryForm";
	}
	
	@PostMapping
	public String setCategory(@Valid CategoryCommand command,Model model)
	{
		
		command=service.setCategory(command);
		model.addAttribute("categories", service.getAllCategory());
		model.addAttribute("category",command);
		
		
		return "categoryForm";
	}
	
	@DeleteMapping
	public String deleteCategory(CategoryCommand command,Model model)
	{
		service.deleteCategory(command);
		model.addAttribute("categories", service.getAllCategory());
		model.addAttribute("category",command);

		return "categoryForm";
		
	}
	
	
}
