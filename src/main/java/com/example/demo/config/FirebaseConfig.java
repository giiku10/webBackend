package com.example.demo.config;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;

//Initialize Firebase Admin SDK
@Component
public class FirebaseConfig {
	
	GoogleCredentials credentials;
	
	public FirebaseConfig()throws IOException {
		//秘密鍵はGOOGLE_APPLICATION_CREDENTIALS環境変数で指定
		this.credentials = GoogleCredentials.getApplicationDefault();
	}
	
	@Nullable
	public String errorString = null;
	
	FirebaseOptions options = FirebaseOptions.builder()
			.setCredentials(credentials)
			.setDatabaseUrl("https://kan-sou-ki-default-rtdb.asia-southeast1.firebasedatabase.app")
			.build();
	
	FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
	
	public FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(firebaseApp);
	
	public FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(firebaseApp);
}
