package com.cg.payment.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.payment.entity.Payment;
import com.cg.payment.exception.PaymentFailException;
import com.cg.payment.exception.PaymentNotFoundWithIdException;
import com.cg.payment.repository.PaymentRepository;

@Service
public class PaymentServiceImp implements PaymentService {

	@Autowired
	PaymentRepository repository;

	//Method to make payment
	@Override
	public Payment doPayment(String userName, double amount) throws PaymentFailException {
		boolean paymentDone = false;
		try {
			Payment payment = new Payment();

			payment.setTransactionId(UUID.randomUUID().toString());
			payment.setUserName(userName);
			payment.setAmount(amount);
			payment.setTransactionStatus("Payment Successful");
			paymentDone = true;
			return repository.save(payment);

		} catch (Exception e) {
			// TODO: handle exception

			throw new PaymentFailException("Payment Failed of RS " + amount);

		}

	}
	
	//method to get all payments
	@Override
	public List<Payment> getAll(){
		List<Payment> pl=repository.findAll();
		return pl;
	}
	
	//method to get payment by transactionId
	@Override
	public Payment getPayment(String transactionId) throws PaymentNotFoundWithIdException {
		

		Optional<Payment> optionalPayment = repository.findById(transactionId);

		if (optionalPayment.isPresent()) {

			return optionalPayment.get();

		} else {
			throw new PaymentNotFoundWithIdException("Payment not found with transactionId " + transactionId);
		}
	}

	
	@Override
	public Payment updatePayment(String transactionId, Payment payment) throws PaymentNotFoundWithIdException {
		
		Optional<Payment> payment1 = repository.findById(transactionId);
		if (payment1.isPresent()) {
		} else {
			throw new PaymentNotFoundWithIdException("Payment not found with transactionId " + transactionId);
		}
		repository.save(payment);
		return payment;
	}

}
