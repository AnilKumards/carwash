package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.CartDetails;
import com.example.demo.model.CartItem;
import com.example.demo.service.CartItemService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/api")
public class CartItemController {

	@Autowired
	private CartItemService service;
	
	private static final Logger log = LoggerFactory.getLogger(CartController.class);
	
	
	@GetMapping("/cartItemList")
	public ResponseEntity<?> getAllCartItem() {
		Map<String, Object> ciMap = new HashMap<String, Object>();
		ciMap.put("status", "success");
		ciMap.put("data", service.getAllCartItem());
		log.info("---Fetching all the CartItem Details---");
		return ResponseEntity.ok(ciMap);
	}
		@PostMapping("/cart/item")
		public ResponseEntity<?> savecartItem(@RequestBody CartItem cartItem){
			Optional<CartItem> optional = service.getCartItemId(cartItem.getCartItemId());
					
		log.error("Id is already exist");
		throw new BadRequestException("Id is already exist");}
			

}
