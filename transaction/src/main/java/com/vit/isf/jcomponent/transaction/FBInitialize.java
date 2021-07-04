package com.vit.isf.jcomponent.transaction;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
@Service
public class FBInitialize {

	@PostConstruct
	public void initialize() {
		try {

			FileInputStream serviceAccount = new FileInputStream("/home/soumadeepdhar/Applications/VIT Vellore/Software/Project/transaction-credswagger/transaction/src/main/resources/transaction-26ae4-firebase-adminsdk-7vqgr-d142e86512.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://transaction-26ae4-default-rtdb.firebaseio.com").build();

			FirebaseApp.initializeApp(options);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
