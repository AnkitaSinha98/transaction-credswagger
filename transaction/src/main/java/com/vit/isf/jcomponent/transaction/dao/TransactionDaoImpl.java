package com.vit.isf.jcomponent.transaction.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vit.isf.jcomponent.transaction.model.Audit;

@Repository
public class TransactionDaoImpl implements TransactionDao {

	@Autowired
	private AuditRepository audirepository;
	
	@Autowired
	private FinanceRepository financeRepository;

	@Override
	public void addTransaction(Audit audit) {
		audirepository.insert(audit);
	}

	@Override
	public List<Audit> getTransaction(String name) {
		return audirepository.findAll();
	}

	
	
	
}
