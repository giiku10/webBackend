package com.example.demo.config;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;

@Component
public class FirestoreConfig {
	
	private final String projectId = "kansou-ki";
	private GoogleCredentials credentials;
	
	public FirestoreConfig()throws IOException {
		//秘密鍵はGOOGLE_APPLICATION_CREDENTIALS環境変数で指定
		this.credentials = GoogleCredentials.getApplicationDefault();
	}
	
	FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance()
			.toBuilder()
			.setProjectId(projectId)
			.setCredentials(credentials)
			.build();
	
	public Firestore database = firestoreOptions.getService();
}
