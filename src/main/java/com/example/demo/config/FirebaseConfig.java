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

	// GoogleCredentials credentials;

	// @Nullable
	// public String errorString = null;
	// public FirebaseDatabase firebaseDatabase;
	// public FirebaseAuth firebaseAuth;

	// public FirebaseConfig() {
	// // 秘密鍵はGOOGLE_APPLICATION_CREDENTIALS環境変数で指定
	// try {
	// 		var credentials = GoogleCredentials.getApplicationDefault();
	// 		FirebaseOptions options = FirebaseOptions.builder()
	// 				.setCredentials(credentials)
	// 				.build();

	// 		FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
	// 		firebaseAuth = FirebaseAuth.getInstance(firebaseApp);
	// 	} catch (IOException e) {
	// 		errorString = e.getMessage();
	// 	}
	// }

}
