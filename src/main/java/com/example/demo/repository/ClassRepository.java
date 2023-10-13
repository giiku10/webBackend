package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Class;

public interface ClassRepository extends JpaRepository<Class, Long> {
	
}
