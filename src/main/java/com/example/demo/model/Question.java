package com.example.demo.model;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Question {
	
	//repositoryがカスタムオブジェクトとして取得するためのコンストラクタ
	public Question(){
	}
	
	@Id
	private String id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String parent;
	
	private Long comprehensionLevel;
}
