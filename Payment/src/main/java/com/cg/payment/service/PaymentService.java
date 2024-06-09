package com.cg.payment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.payment.entity.Payment;
import com.cg.payment.exception.PaymentFailException;
import com.cg.payment.exception.PaymentNotFoundWithIdException;

public interface PaymentService {

	Payment doPayment(String userName, double amount) throws PaymentFailException;

	Payment getPayment(String transactionId) throws PaymentNotFoundWithIdException;
	
	List<Payment> getAll();

	Payment updatePayment(String transactionId, Payment payment) throws PaymentNotFoundWithIdException;

}
