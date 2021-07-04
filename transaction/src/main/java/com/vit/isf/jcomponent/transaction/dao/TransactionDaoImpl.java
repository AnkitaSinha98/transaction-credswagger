package com.vit.isf.jcomponent.transaction.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vit.isf.jcomponent.transaction.model.Audit;
import com.vit.isf.jcomponent.transaction.model.Finance;

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

	@Override
	public List<Finance> getFinanceData() {
		Finance finance = new Finance();
		finance.setExchange("Result Found");
		List<Finance> finances = new ArrayList<Finance>();
	finances.add(finance);
		List<Finance>  financeList = financeRepository.findAll();
		System.out.println(financeList);
		return finances;
	}
	
	
}
