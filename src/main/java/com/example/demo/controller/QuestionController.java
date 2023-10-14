package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Class;
import com.example.demo.model.Question;
import com.example.demo.repository.ClassRepository;
import com.example.demo.repository.QuestionRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class QuestionController {
	private final ClassRepository classRepository;
	private final QuestionRepository questionRepository;
	
	public QuestionController(ClassRepository classRepository, QuestionRepository questionRepository) {
		this.classRepository = classRepository;
		this.questionRepository = questionRepository;
	}
	
	@Operation(summary = "Classを全件取得")
	@GetMapping("/classes")
	public List<Class> getClasses(){
		return classRepository.findAll();
	}
	
	/**@Operation(summary = "授業を1件取得")
	@GetMapping("/{classId}")
	public Class getClass(@PathVariable Long classId){
		return classRepository.findById(classId).get();
	}
	
	@Operation(summary = "特定の授業の問題を全件取得")
	@GetMapping("/{classId}/questions")
	public List<Question> getQuestions(@PathVariable Long classId){
		return questionRepository.findAllInClass(classId);
	}
	
	@Operation(summary = "特定の授業の問題を1件取得")
	@GetMapping("/{classId}/{questionId}")
	public Question getQuestion(@PathVariable Long classId, @PathVariable Long questionId){
		return questionRepository.findByIdInClass(classId, questionId).get();
	}*/
	
	/**@Operation(summary = "特定の授業の大問のみまたは中問のみまたは小問のみを全件取得")
	@GetMapping("/{classId}/{parentQuestionId}/questions")
	public List<Question> getQuestions(@PathVariable Long classId, @PathVariable Long parentQuestionId){
		return questionRepository.findAllQuestions(classId, parentQuestionId);
	}*/
	
	@Operation(summary = "特定のClassのPartを全件取得")
	@GetMapping("/{classId}/Parts")
	public List<Question> getParts(@PathVariable String classId){
		return questionRepository.findAllParts(classId);
	}
	
	@Operation(summary = "特定のClassのfileのPartを全件取得")
	@GetMapping("/{classId}/fileParts")
	public List<Question> getFileParts(@PathVariable String classId){
		return questionRepository.findAllFileParts(classId);
	}
	
	@Operation(summary = "特定のClassのfolderのPartを全件取得")
	@GetMapping("/{classId}/folderParts")
	public List<Question> getFolderParts(@PathVariable String classId){
		return questionRepository.findAllFolderParts(classId);
	}
	
	@Operation(summary = "特定のPartのQuestionを全件取得")
	@GetMapping("/{partId}/folderParts")
	public List<Question> getQuestionsInPart(@PathVariable String partId){
		return questionRepository.findAllQuestionsInPart(partId);
	}
	
	/**@Operation(summary = "特定の授業の大問を全件取得")
	@GetMapping("/{classId}/daimon")
	public List<Question> getDaimon(@PathVariable Long classId){
		return questionRepository.findAllDaimonInSubject(classId);
	}
	
	@Operation(summary = "特定の大問の中問を全件取得")
	@GetMapping("/{classId}/{daimonId}/chumon")
	public List<Question> getChumon(@PathVariable Long classId, @PathVariable Long daimonId){
		return questionRepository.findAllChumonInDaimon(classId, daimonId);
	}
	
	@Operation(summary = "特定の中問の小問を全件取得")
	@GetMapping("/{classId}/{daimonId}/{chumonId}/shomon")
	public List<Question> getShomon(@PathVariable Long classId, @PathVariable Long daimonId, @PathVariable Long chumonId){
		return questionRepository.findAllShomonInChumon(classId, chumonId);
	}*/
	
	@Operation(summary = "特定の授業の問題を理解度を更新")
	@PutMapping("/{classId}/{questionId}")
	public Question saveComprehensionLevel(@PathVariable Long classId, @PathVariable Long questionId, @RequestBody Long comprehensionLevel){
		Question question = questionRepository.findByIdInClass(classId, questionId).get();
		question.setComprehensionLevel(comprehensionLevel);
		return questionRepository.save(question);
	}
	
}
