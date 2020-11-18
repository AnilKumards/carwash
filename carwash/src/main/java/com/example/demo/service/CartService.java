package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CartDetails;
import com.example.demo.model.Customer;
import com.example.demo.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	public List<CartDetails> getAllCart(){
		return cartRepository.findAll();
	}
	
	public Optional<CartDetails> getCartById(Integer cartid){
		Optional<CartDetails> optional = cartRepository.findByCartid(cartid);
		return optional;
	}
	
	public CartDetails saveCartDetails(CartDetails cart) {
		System.out.println("cartDetails" + cart);
		return cartRepository.save(cart);
	}
	
	 public void deleteByCartId(Integer cartid) {
		cartRepository.deleteByCartid(cartid);
	}
}
