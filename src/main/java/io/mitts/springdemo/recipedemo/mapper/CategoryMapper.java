package io.mitts.springdemo.recipedemo.mapper;

import io.mitts.springdemo.recipedemo.command.CategoryCommand;
import io.mitts.springdemo.recipedemo.domain.Category;

public class CategoryMapper {

	
	public static CategoryCommand  convertToCategoryCommand(Category category)
	{
		CategoryCommand command=new CategoryCommand();
		command.setDescription(category.getDescription());
		command.setId(category.getId());
		
		return command;
	}
	
	
	public static Category convertToCategory(CategoryCommand command)
	{
		Category category=new Category();
		category.setDescription(command.getDescription());
		category.setId(command.getId());
		return category;
		
	}
}
