package com.example.demo.model;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Class {
	
	//repositoryがカスタムオブジェクトとして取得するためのコンストラクタ
	public Class() {
	}
	
	@Id
	private String id;
	
	@NotBlank
	private String name;
}
