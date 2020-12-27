package io.mitts.springdemo.recipedemo.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.mitts.springdemo.recipedemo.command.CategoryCommand;
import io.mitts.springdemo.recipedemo.domain.Category;
import io.mitts.springdemo.recipedemo.exception.DataNotFoundException;
import io.mitts.springdemo.recipedemo.mapper.CategoryMapper;
import io.mitts.springdemo.recipedemo.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	CategoryRepository repository;

	public CategoryServiceImpl(CategoryRepository repository) {
		this.repository = repository;
	}
	
	
	public CategoryCommand findOne(Long id)
	{
		Optional<Category> categoryOp=repository.findById(id);
		if(!categoryOp.isPresent())
		{
			throw new DataNotFoundException("No Category with the id : "+id);
		}
		else
		{
			return CategoryMapper.convertToCategoryCommand(categoryOp.get());
		}
	}

	@Override
	public Set<CategoryCommand> getAllCategory() {

		Set<CategoryCommand> commands = new HashSet<CategoryCommand>();
		repository.findAll().iterator().forEachRemaining(new Consumer<Category>() {

			@Override
			public void accept(Category category) {
				commands.add(CategoryMapper.convertToCategoryCommand(category));

			}

		});

		return commands;

	}

	@Override
	@Transactional
	public CategoryCommand setCategory(CategoryCommand command) {
		
		return CategoryMapper.convertToCategoryCommand(repository.save(CategoryMapper.convertToCategory(command)));

	}

	@Override
	public void deleteCategory(CategoryCommand command) {
		
		repository.delete(repository.findById(command.getId()).get());
		
	}

}
