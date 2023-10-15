package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

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
