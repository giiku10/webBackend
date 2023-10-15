package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.config.FirebaseClass;
import com.example.demo.model.Question;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

public class QuestionRepository {
	
	private FirebaseClass firestoreConfig;
	
	//コンストラクタインジェクション
	@Autowired
	public QuestionRepository(FirebaseClass firestoreConfig){
		this.firestoreConfig = firestoreConfig;
	}
	
	private final CollectionReference partsReference = firestoreConfig.db.collection("Parts");
	private final CollectionReference questionsReference = firestoreConfig.db.collection("Question");
	
	public List<Question> findAllParts(String classId) throws InterruptedException, ExecutionException{
		List<Question> questions = new ArrayList<Question>();
		ApiFuture<QuerySnapshot> future = partsReference.whereEqualTo("parent", classId).get();
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			questions.add(document.toObject(Question.class));
		}
		return questions;
	}
	
	public List<Question> findAllFileParts(String classId) throws InterruptedException, ExecutionException{
		List<Question> questions = new ArrayList<Question>();
		ApiFuture<QuerySnapshot> future = partsReference.whereEqualTo("parent", classId).whereEqualTo("detail", "file").get();
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			questions.add(document.toObject(Question.class));
		}
		return questions;
	}
	
	public List<Question> findAllFolderParts(String classId) throws InterruptedException, ExecutionException{
		List<Question> questions = new ArrayList<Question>();
		ApiFuture<QuerySnapshot> future = partsReference.whereEqualTo("parent", classId).whereEqualTo("detail", "folder").get();
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			questions.add(document.toObject(Question.class));
		}
		return questions;
	}
	
	public List<Question> findAllQuestionsInPart(String partId) {
		List<Question> questions = new ArrayList<Question>();
		ApiFuture<QuerySnapshot> future = questionsReference.whereEqualTo("parent", partId).get();
		List<QueryDocumentSnapshot> documents;
		try {
			documents = future.get().getDocuments();
			for (QueryDocumentSnapshot document : documents) {
				questions.add(document.toObject(Question.class));
			}
			return questions;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return questions;
		}

	}
	
	public Question findQuestionInPart(String questionId) throws InterruptedException, ExecutionException{
		Question question;
		ApiFuture<DocumentSnapshot> future = questionsReference.document(questionId).get();
		DocumentSnapshot document = future.get();
		question = document.toObject(Question.class);
		return question;
	}
	
	public void updateDifficulty(String questionId, Long difficulty) {
		DocumentReference documentReference = questionsReference.document(questionId);
		documentReference.update("difficulty", difficulty);
	}
	
}
