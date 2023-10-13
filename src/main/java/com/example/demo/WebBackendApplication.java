package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(
		title = "Web Backend API",
		version = "1.0.0",
		description = "問題の取得と理解度の登録を行う"
))
@SpringBootApplication
public class WebBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebBackendApplication.class, args);
	}

}
