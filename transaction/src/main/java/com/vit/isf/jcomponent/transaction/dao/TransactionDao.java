package com.vit.isf.jcomponent.transaction.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vit.isf.jcomponent.transaction.model.Audit;
import com.vit.isf.jcomponent.transaction.model.Finance;

@Repository
public interface TransactionDao {

	public void addTransaction(Audit audit);
	
	public List<Audit> getTransaction(String name);
	
	public List<Finance> getFinanceData();
}
