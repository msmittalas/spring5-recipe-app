package io.mitts.springdemo.recipedemo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import io.mitts.springdemo.recipedemo.domain.UnitofMeasure;

public interface UOMRepository  extends CrudRepository<UnitofMeasure, Long>{


	public Optional<UnitofMeasure> findByDescription(String description);
}
