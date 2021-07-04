/**
 * 
 */
package com.vit.isf.jcomponent.transaction.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vit.isf.jcomponent.transaction.model.Audit;
import com.vit.isf.jcomponent.transaction.model.Finance;
import com.vit.isf.jcomponent.transaction.service.TransactionService;

/**
 * @author soumadeepdhar
 *
 */

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/Blockchain/accessBlockchain")
	public Audit BlockchainAccess(@RequestParam("id") Integer id, @RequestParam("name") String name) throws InterruptedException, ExecutionException {
		return transactionService.createTransaction(id,name);
	}

	@GetMapping("/Blockchain/getBlockchain")
	public List<Audit> getBlockchain(@RequestParam("name") String name) {
		return 	transactionService.getTransaction(name);
	}
	
	@GetMapping("/Blockchain/getFinance")
	public List<Finance> getFinance() {
		return 	transactionService.getFinanceData();
	}
}
