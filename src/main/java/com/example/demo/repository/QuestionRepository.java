package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Question;

//これは仮のrepositoryで実際にはFirebase Admin SDKを用いてrepositoryの記述??
public interface QuestionRepository extends JpaRepository<Question, Long> {
	Optional<Question> findByIdInClass(Long classId, Long questionId);
	
	List<Question> findAllQuestions(Long classId, Long parentQuestionId);
	//WHERE Question.classId = classId, Question.parentQuestionId = parentQuestionId
	
	/**List<Question> findAllDaimonInSubject(Long classId);
	//WHERE Question.classId = classId, Question.parentQuestionId = 0
	List<Question> findAllChumonInDaimon(Long classId, Long daimonId);
	//WHERE Question.classId = classId, Question.parentQuestionId = daimonId
	List<Question> findAllShomonInChumon(Long classId, Long chumonId);
	//WHERE Question.classId = classId, Question.parentQuestionId = chumonId*/
}
