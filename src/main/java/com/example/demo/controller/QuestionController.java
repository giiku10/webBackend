package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.FirebaseClass;
import com.example.demo.model.Class;
import com.example.demo.model.Question;
import com.example.demo.repository.ClassRepository;
import com.example.demo.repository.QuestionRepository;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class QuestionController {
	private FirebaseClass firestoreConfig = new FirebaseClass();
	private ClassRepository classRepository = new ClassRepository(firestoreConfig);
	private QuestionRepository questionRepository = new QuestionRepository(firestoreConfig);

	@Operation(summary = "Classを全件取得")
	@GetMapping("/classes")
	public List<Class> getClasses() throws InterruptedException, ExecutionException {
		return classRepository.findAll();
	}

	@Operation(summary = "特定のClassのPartを全件取得")
	@GetMapping("/{classId}/Parts")
	public List<Question> getParts(@PathVariable String classId) throws InterruptedException, ExecutionException {
		List<Question> questions = questionRepository.findAllParts(classId);
		for (int i = 0; i < questions.size(); i++) {
			questions.get(i).load(questionRepository);
		}
		return questions;
	}

	@Operation(summary = "特定のClassのfileのPartを全件取得")
	@GetMapping("/{classId}/fileParts")
	public List<Question> getFileParts(@PathVariable String classId) throws InterruptedException, ExecutionException {
		return questionRepository.findAllFileParts(classId);
	}

	@Operation(summary = "特定のClassのfolderのPartを全件取得")
	@GetMapping("/{classId}/folderParts")
	public List<Question> getFolderParts(@PathVariable String classId) throws InterruptedException, ExecutionException {
		return questionRepository.findAllFolderParts(classId);
	}

	@Operation(summary = "特定のPartのQuestionを全件取得")
	@GetMapping("/{classId}/{partId}/Questions")
	public List<Question> getQuestionsInPart(@PathVariable String classId, @PathVariable String partId)
			throws InterruptedException, ExecutionException {
		return questionRepository.findAllQuestionsInPart(partId);
	}

	@Operation(summary = "特定のPartのQuestionを1件取得")
	@GetMapping("/{classId}/{partId}/{questionId}")
	public Question getQuestionInPart(@PathVariable String classId, @PathVariable String partId,
			@PathVariable String questionId) throws InterruptedException, ExecutionException {
		return questionRepository.findQuestionInPart(questionId);
	}

	@Operation(summary = "特定のPartのQuestionのdifficultyを代入した値に更新")
	@PutMapping(path = "/{classId}/{partId}/{questionId}", params = "difficuty")
	public void savedifficulty(@PathVariable String classId, @PathVariable String partId, @PathVariable String questionId,
			@RequestParam("difficulty") Long difficulty) throws ExecutionException, InterruptedException {
		Question question = questionRepository.findQuestionInPart(questionId);
		question.setDifficulty(difficulty);
	}

}
