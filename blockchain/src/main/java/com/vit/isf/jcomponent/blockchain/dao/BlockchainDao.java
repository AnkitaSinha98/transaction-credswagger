package com.vit.isf.jcomponent.blockchain.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vit.isf.jcomponent.blockchain.model.Audit;
import com.vit.isf.jcomponent.blockchain.model.Finance;

@Repository
public interface BlockchainDao {

	public void addBlockchain(Audit audit);
	
	public List<Audit> getBlockchain(String name);
	
	public List<Finance> getFinanceData();
}
