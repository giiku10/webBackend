package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.example.demo.repository.QuestionRepository;

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
	private String detail;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String parent;
	
	private Long difficulty;
	
	private List<Question> questions = new ArrayList<>();
	
	void load(QuestionRepository questionRepository) {
		if(detail.equals("folder")){
			questions = questionRepository.findAllQuestionsInPart(this.id);
			for (int i = 0; i < questions.size(); i++){
				questions.get(i).load(questionRepository);
			}
		}
	}
}
