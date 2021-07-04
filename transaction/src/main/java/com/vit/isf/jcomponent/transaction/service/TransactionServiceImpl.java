package com.vit.isf.jcomponent.transaction.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vit.isf.jcomponent.transaction.dao.TransactionDao;
import com.vit.isf.jcomponent.transaction.model.Audit;
import com.vit.isf.jcomponent.transaction.model.Finance;

/**
 * @author soumadeepdhar
 *
 */

@Component
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDao transactiondao;

	@Override
	public Audit createTransaction(int id, String name) {
		Audit audit = new Audit();
		if (id != 0) {
			audit = auditDataset(id,name);
			String data = audit.toString();
			System.out.println("The data is : "+data);
			String hashcode = getSecureData(data,id);
			audit.setaId(hashcode);
		}
		transactiondao.addTransaction(audit);

		return audit;
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
			Integer value = new Integer(privateKey);   // SALT Value
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
	private Audit auditDataset(int id, String name) {
		Audit auditValue = new Audit();
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
