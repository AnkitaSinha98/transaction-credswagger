/**
 * 
 */
package com.vit.isf.jcomponent.blockchain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vit.isf.jcomponent.blockchain.model.Audit;
import com.vit.isf.jcomponent.blockchain.model.Finance;
import com.vit.isf.jcomponent.blockchain.service.BlockchainService;

/**
 * @author soumadeepdhar
 *
 */

@RestController
public class BlockchainController {
	
	@Autowired
	BlockchainService blockchainservice;
	
	@PostMapping("/Blockchain/accessBlockchain")
	public Audit BlockchainAccess(@RequestParam("id") Integer id) {
		return blockchainservice.createAudit(id);
	}

	@GetMapping("/Blockchain/getBlockchain")
	public List<Audit> getBlockchain(@RequestParam("name") String name) {
		return 	blockchainservice.getBlockchain(name);
	}
	
	@GetMapping("/Blockchain/getFinance")
	public List<Finance> getFinance() {
		return 	blockchainservice.getFinanceData();
	}
}
