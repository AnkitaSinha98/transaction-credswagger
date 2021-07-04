package com.vit.isf.jcomponent.blockchain.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vit.isf.jcomponent.blockchain.dao.BlockchainDao;
import com.vit.isf.jcomponent.blockchain.model.Audit;
import com.vit.isf.jcomponent.blockchain.model.Finance;

/**
 * @author soumadeepdhar
 *
 */

@Component
public class BlockchainServiceImpl implements BlockchainService {

	@Autowired
	BlockchainDao blockchaindao;

	@Override
	public Audit createAudit(int id) {
		Audit audit = new Audit();
		if (id != 0) {
			audit = auditDataset(id);
			String data = audit.toString();
			String hashcode = getSecureData(data,id);
			audit.setaId(hashcode);
		}
		blockchaindao.addBlockchain(audit);

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
			Integer value = new Integer(privateKey+5);   // SALT Value
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
	 * @return
	 */
	private Audit auditDataset(int id) {
		Audit auditValue = new Audit();
		switch (id) {
		case 1:
			auditValue.setAuditName("Soumadeep");
			auditValue.setAuditData(
					"Audit Data for the particular value of block chain is found for " + auditValue.getAuditName());
			break;
		case 2:
			auditValue.setAuditName("Akashdeep");
			auditValue.setAuditData(
					"Audit Data for the particular value of block chain is found for " + auditValue.getAuditName());
			break;
		case 3:
			auditValue.setAuditName("Sundori");
			auditValue.setAuditData(
					"Audit Data for the particular value of block chain is found for " + auditValue.getAuditName());
			break;
		case 4:
			auditValue.setAuditName("Pucchu");
			auditValue.setAuditData(
					"Audit Data for the particular value of block chain is found for " + auditValue.getAuditName());
			break;
		case 5:
			auditValue.setAuditName("Lalu");
			auditValue.setAuditData(
					"Audit Data for the particular value of block chain is found for " + auditValue.getAuditName());
			break;
		default:
			System.out.println("The Audit Id which you are looking is not found !!");
			break;
		}
		return auditValue;

	}

	@Override
	public List<Audit> getBlockchain(String name) {
		List<Audit> auditlist = blockchaindao.getBlockchain(name);
		return auditlist;

	}

	@Override
	public List<Finance> getFinanceData() {
		return blockchaindao.getFinanceData();
	}

}
