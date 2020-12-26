package io.mitts.springdemo.recipedemo.repository;

import org.springframework.data.repository.CrudRepository;

import io.mitts.springdemo.recipedemo.domain.Recipe;

public interface RecipeRepository  extends CrudRepository<Recipe, Long>{

}
