package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.config.FirestoreConfig;
import com.example.demo.model.Class;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

public class ClassRepository {

	private FirestoreConfig firestoreConfig;
	
	//コンストラクタインジェクション
	@Autowired
	public ClassRepository(FirestoreConfig firestoreConfig){
		this.firestoreConfig = firestoreConfig;
	}
	
	private final CollectionReference classesReference = firestoreConfig.database.collection("Class");
	
	public List<Class> findAll() throws InterruptedException, ExecutionException{
		List<Class> classes = new ArrayList<Class>();
		ApiFuture<QuerySnapshot> future = classesReference.get();
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			classes.add(document.toObject(Class.class));
		}
		return classes;
	}
	
}
