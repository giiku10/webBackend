package com.example.demo.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.annotations.Nullable;

public class FirebaseClass {
  public Firestore db;
  public FirebaseAuth firebaseAuth;
  @Nullable
  public String errorString = null;

  public FirebaseClass() {
    FileInputStream serviceAccount;
    try {
      // ここは適切にpathを変える
      serviceAccount = new FileInputStream(
          "E:/firebase/webBackend/kansou-ki-firebase-adminsdk-8s0yf-45b273b23f.json");

      // FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
      //     .setCredentials(GoogleCredentials.fromStream(serviceAccount))
      //     .build();

      FirebaseOptions options = new FirebaseOptions.Builder()
          .setCredentials(GoogleCredentials.fromStream(serviceAccount))
          .build();
      FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
      firebaseAuth = FirebaseAuth.getInstance(firebaseApp);
      db = FirestoreClient.getFirestore(firebaseApp);
    } catch (FileNotFoundException e) {
      System.out.println("file not found");
      errorString = e.getMessage();
    } catch (IOException e) {
      System.out.println("io exception");
      errorString = e.getMessage();
    }
  }
}
