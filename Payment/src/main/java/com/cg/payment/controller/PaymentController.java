package com.cg.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.cg.payment.entity.Payment;
import com.cg.payment.exception.PaymentFailException;
import com.cg.payment.exception.PaymentNotFoundWithIdException;
import com.cg.payment.repository.PaymentRepository;
import com.cg.payment.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService service;
	
	//EndPoint to make payment.
	@GetMapping("/doPayment/{userName}/{amount}")
	public Payment doPayment(@PathVariable String userName,@PathVariable double amount) throws Exception {
		
		return service.doPayment(userName,amount);
		
	}
	
	//EndPoint to get all transactions
	@GetMapping("/getAll")
	public List<Payment> getAll(){
		List<Payment> paymentList=service.getAll();
		return paymentList;
	}
	
	//EndPoint to get Transaction based on TransactionId.
	@GetMapping("/getByTransactionId/{transactionId}")
	public ResponseEntity<Payment> getPayment(@PathVariable String transactionId) throws PaymentNotFoundWithIdException {
		
		Payment payment= service.getPayment(transactionId);
		
		return new ResponseEntity<Payment>(payment,HttpStatus.OK);
	}
	
	//EndPoint to Update Payment.
	@PutMapping("/update/{transactionId}")
	public ResponseEntity<Payment> updatePayment(@PathVariable String transactionId,@RequestBody Payment payment) throws PaymentNotFoundWithIdException {
		
		Payment payment2= service.updatePayment(transactionId, payment);
		
		return new ResponseEntity<Payment>(payment2,HttpStatus.OK);
		
	}

}
