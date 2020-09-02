package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CartDetails;

@Repository
public interface CartRepository extends MongoRepository<CartDetails, Integer>{

	Optional<CartDetails> findByCartid(Integer cartid);
	
	void deleteByCartid(Integer cartid);
	 
}
