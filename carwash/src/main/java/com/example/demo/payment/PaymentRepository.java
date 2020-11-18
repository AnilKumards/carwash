package com.example.demo.payment;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String>{

	Payment findByTxnId(String txnid);
}
