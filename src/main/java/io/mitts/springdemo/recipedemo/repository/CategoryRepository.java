package io.mitts.springdemo.recipedemo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import io.mitts.springdemo.recipedemo.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	
	public Optional<Category> findByDescription(String description);
}
