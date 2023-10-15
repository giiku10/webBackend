package com.example.demo.config;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
// import com.google.cloud.firestore.FirestoreOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.internal.Nullable;

@Component
public class FirestoreConfig {

	// private GoogleCredentials credentials;

	@Nullable
	public Firestore database = null;

	public FirestoreConfig() {
		// 秘密鍵はGOOGLE_APPLICATION_CREDENTIALS環境変数で指定
		try {
			var credentials = GoogleCredentials.getApplicationDefault();
			System.out.println(credentials);
			FirebaseOptions options = FirebaseOptions.builder()
					.setCredentials(credentials)
					.build();

			FirebaseApp app = FirebaseApp.initializeApp(options);
			// FirestoreOptions firestoreOptions;
			// firestoreOptions = FirestoreOptions.getDefaultInstance()
			// .toBuilder()
			// .setCredentials(credentials)
			// .build();
			try {
				database = FirestoreClient.getFirestore(app);
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println(e);
		}
	}

}
