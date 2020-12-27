package io.mitts.springdemo.recipedemo.service;

import java.util.Set;

import io.mitts.springdemo.recipedemo.command.CategoryCommand;
import io.mitts.springdemo.recipedemo.domain.Category;
import io.mitts.springdemo.recipedemo.exception.DataNotFoundException;

public interface CategoryService {

	
	Set<CategoryCommand> getAllCategory();
	CategoryCommand setCategory(CategoryCommand command);
	void deleteCategory(CategoryCommand command);
	public CategoryCommand findOne(Long id);
	
}
