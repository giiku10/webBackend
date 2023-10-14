package com.example.demo.config;

import org.springframework.stereotype.Component;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;

@Component
public class FirestoreConfig {
	
	private final String projectId = "kansou-ki";
	
	FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance()
			.toBuilder()
			.setProjectId(projectId)
			.setCredentials(GoogleCredentials.getApplicationDefault())
			.build();
	
	public Firestore database = firestoreOptions.getService();
}
