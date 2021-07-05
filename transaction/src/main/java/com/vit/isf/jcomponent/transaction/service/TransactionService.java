package com.vit.isf.jcomponent.transaction.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.vit.isf.jcomponent.transaction.model.Audit;

@Service
public interface TransactionService{

	public Audit createTransaction(int id, String name) throws InterruptedException, ExecutionException;

	public List<Audit> getTransaction(String name);

	public Audit getTransactionAid(String aid) throws InterruptedException, ExecutionException;
	
}
