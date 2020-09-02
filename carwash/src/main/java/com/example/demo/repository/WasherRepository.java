package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Washer;

public interface WasherRepository extends MongoRepository<Washer,String> {

	Washer findByEmail(String email);

}
