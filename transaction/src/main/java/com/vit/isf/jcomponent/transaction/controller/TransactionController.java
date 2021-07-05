
package com.vit.isf.jcomponent.transaction.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vit.isf.jcomponent.transaction.model.Audit;
import com.vit.isf.jcomponent.transaction.model.Finance;
import com.vit.isf.jcomponent.transaction.service.TransactionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author soumadeepdhar
 *
 */
@Api(value = "TransactionController", description = "REST Apis related to Transaction Entity")
@RequestMapping("/Transaction")
@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@ApiOperation(value = "Create transaction ID using Name and Id", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping("/accessTransaction")
	public Audit BlockchainAccess(@RequestParam("id") Integer id, @RequestParam("name") String name)
			throws InterruptedException, ExecutionException {
		return transactionService.createTransaction(id, name);
	}

	@ApiOperation(value = "View transactions by Name", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/getTransaction")
	public List<Audit> getBlockchain(@RequestParam("name") String name) {
		return transactionService.getTransaction(name);
	}

	@ApiOperation(value = "View all transactions", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/getFinance")
	public List<Finance> getFinance() {
		return transactionService.getFinanceData();
	}
}
