package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.CartItem;

@Repository
public interface CartItemRepository extends MongoRepository<CartItem, Integer>{
	
//	void deleteByCartItemId(Integer cartItemId);
	
	Optional<CartItem> findByCartItemId(Integer cartItemId);

}
