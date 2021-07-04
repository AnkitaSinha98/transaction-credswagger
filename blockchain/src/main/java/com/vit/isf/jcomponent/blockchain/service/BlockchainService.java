package com.vit.isf.jcomponent.blockchain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vit.isf.jcomponent.blockchain.model.Audit;
import com.vit.isf.jcomponent.blockchain.model.Finance;

@Service
public interface BlockchainService{

	public Audit createAudit(int id);

	public List<Audit> getBlockchain(String name);
	
	public List<Finance> getFinanceData();
}
