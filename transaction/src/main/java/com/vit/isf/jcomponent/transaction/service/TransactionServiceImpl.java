package com.vit.isf.jcomponent.transaction.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.vit.isf.jcomponent.transaction.dao.TransactionDao;
import com.vit.isf.jcomponent.transaction.model.Audit;
import com.vit.isf.jcomponent.transaction.model.Auditfb;
import com.vit.isf.jcomponent.transaction.model.Finance;

/**
 * @author soumadeepdhar
 *
 */

@Component
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDao transactiondao;

	public static final String COL_NAME = "users";

	@Override
	public Audit createTransaction(int id, String name) throws InterruptedException, ExecutionException {
		Auditfb auditfb = new Auditfb();
		if (id != 0) {
			auditfb = auditDataset(id, name);
			String data = auditfb.toString();
			System.out.println("The data is : " + data);
			String hashcode = getSecureData(data, id);
			auditfb.setaId(hashcode);
		}
		Audit audit = new Audit();
		audit.setAuditName(auditfb.getAuditName());
		audit.setAuditData(auditfb.getAuditData());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		audit.setCreateTime(formatter.format(date));

		Audit auditfbdata = new Audit();
		auditfbdata.setaId(auditfb.getaId());
		auditfbdata.setCreateTime(audit.getCreateTime());
		transactiondao.addTransaction(audit); // Mongo Local PC
		audit.setaId(auditfb.getaId());
		audit.setCreateTime(audit.getCreateTime());
		saveDetails(auditfbdata, audit);
		return audit;
	}

	/**
	 * 
	 * @param audit 
	 * @param audit
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public String saveDetails(Audit auditfbdata, Audit audit) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(audit.getaId())
				.set(auditfbdata);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

	/**
	 * 
	 * @param name
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public Audit getDetails(String name) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
		ApiFuture<DocumentSnapshot> future = documentReference.get();

		DocumentSnapshot document = future.get();

		Audit audit = null;

		if (document.exists()) {
			audit = document.toObject(Audit.class);
			return audit;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public String deletePatient(String name) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(name).delete();
		return "Document with Patient ID " + name + " has been deleted";
	}

	private String generateKey() {
		Random random = new Random();
		return random.toString();
	}

	/**
	 * @param data
	 * @return
	 */
	private static String getSecureData(String data, int privateKey) {

		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] bytes = md.digest(data.getBytes());
			Integer value = new Integer(privateKey); // SALT Value
			byte input = value.byteValue();
			md.update(input); // Salt implementation
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	/**
	 * @param id
	 * @param name
	 * @return
	 */
	private Auditfb auditDataset(int id, String name) {
		Auditfb auditValue = new Auditfb();
		auditValue.setAuditName(name);
		auditValue.setAuditData(
				"Audit Data for the particular value of block chain is found for " + auditValue.getAuditName());
		return auditValue;
	}

	@Override
	public List<Audit> getTransaction(String name) {
		List<Audit> auditlist = transactiondao.getTransaction(name);
		return auditlist;

	}

	@Override
	public List<Finance> getFinanceData() {
		return transactiondao.getFinanceData();
	}

}
