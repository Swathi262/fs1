package com.cg.payment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.payment.entity.Payment;

public interface PaymentRepository extends MongoRepository<Payment, String> {

	Payment findByBookingId(int bookingId);

	boolean existsByBookingId(int bookingId);

	boolean existsByTransactionId(String transactionId);

}
