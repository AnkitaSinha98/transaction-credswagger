package com.vit.isf.jcomponent.transaction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vit.isf.jcomponent.transaction.model.Audit;
import com.vit.isf.jcomponent.transaction.model.Finance;

@Service
public interface TransactionService{

	public Audit createTransaction(int id, String name);

	public List<Audit> getTransaction(String name);
	
	public List<Finance> getFinanceData();
}
