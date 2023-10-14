package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.config.FirestoreConfig;
import com.example.demo.model.Question;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

public class QuestionRepository {
	
	private final FirestoreConfig firestoreConfig;
	
	//コンストラクタインジェクション
	@Autowired
	public QuestionRepository(FirestoreConfig firestoreConfig){
		this.firestoreConfig = firestoreConfig;
	}
	
	private final CollectionReference partsReference = firestoreConfig.database.collection("Parts");
	private final CollectionReference questionsReference = firestoreConfig.database.collection("Question");
	
	public List<Question> findAllParts(String classId){
		List<Question> questions = new ArrayList<Question>();
		ApiFuture<QuerySnapshot> future = partsReference.whereEqualTo("parent", classId).get();
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			questions.add(document.toObject(Question.class));
		}
		return questions;
	}
	
	public List<Question> findAllFileParts(String classId){
		List<Question> questions = new ArrayList<Question>();
		ApiFuture<QuerySnapshot> future = partsReference.whereEqualTo("parent", classId).whereEqualTo("detail", "file").get();
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			questions.add(document.toObject(Question.class));
		}
		return questions;
	}
	
	public List<Question> findAllFolderParts(String classId){
		List<Question> questions = new ArrayList<Question>();
		ApiFuture<QuerySnapshot> future = partsReference.whereEqualTo("parent", classId).whereEqualTo("detail", "folder").get();
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			questions.add(document.toObject(Question.class));
		}
		return questions;
	}
	
	public List<Question> findAllQuestionsInPart(String partId){
		List<Question> questions = new ArrayList<Question>();
		ApiFuture<QuerySnapshot> future = partsReference.whereEqualTo("parent", partId).get();
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			questions.add(document.toObject(Question.class));
		}
		return questions;
	}
	
}
