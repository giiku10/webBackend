package com.example.demo.model;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Question {
	@Id
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private Long parentQuestionId;
	
	@NotBlank
	private Long classId;
	
	private Long comprehensionLevel;
}
