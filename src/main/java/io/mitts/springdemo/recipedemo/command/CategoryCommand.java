package io.mitts.springdemo.recipedemo.command;

import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryCommand {

	private Long id;
	
	@Size(max = 10)
	private String description;
	
}
