package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CartDetails;
import com.example.demo.model.CartItem;
import com.example.demo.repository.CartItemRepository;

@Service
public class CartItemService {

	@Autowired
	private CartItemRepository repository;
	
	public Optional<CartItem> getCartItemId(Integer cartItemId){
		Optional<CartItem> optional = repository.findByCartItemId(cartItemId);
		return optional;
	}
	
	public CartItem addCertItem(CartItem item) {
		return repository.save(item);
	}
	public CartItem savecartItem(CartItem cart) {
		System.out.println("cartItem" + cart);
	 return repository.save(cart);
	}
	public void deleteCartItem(Integer cartItemId) {
//		repository.deleteByCartItemId(cartItemId);
		
		repository.deleteById(cartItemId);
	}
	
	public List<CartItem> getAllCartItem() {
		return repository.findAll();
	}
	
}
