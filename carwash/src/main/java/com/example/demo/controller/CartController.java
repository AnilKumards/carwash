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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.CartDetails;
import com.example.demo.model.Customer;
import com.example.demo.service.CartService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api")
@CrossOrigin
public class CartController {
	
	private static final Logger log = LoggerFactory.getLogger(CartController.class);
	@Autowired
	private CartService cartService;
	
	@GetMapping("/cart/cartListing")
	public ResponseEntity<?> getCartList(){
		Map<String, Object> cartMap = new HashMap<String, Object>();
		cartMap.put("status", "success");
		cartMap.put("data", cartService.getAllCart());
		log.info("---Fetching all the Cart Details---");
		System.out.println("cartMap" +cartMap);
		return ResponseEntity.ok(cartMap);
	}
	
	@GetMapping("/cartid/{id}")
	public ResponseEntity<?> getCartById(@PathVariable("id") Integer cartid){
		Optional<CartDetails> optional = cartService.getCartById(cartid);
		log.info("---Searching for a Cart with id {} ", cartid);
		if(!optional.isPresent()) {
			log.error("Id "+ cartid + " is not existed");
			ResponseEntity.badRequest().build();
		}
		log.info("---Fetching Cart Details by id---");
		return ResponseEntity.ok(optional.get());	
	}
	
	@PostMapping("/cart/store")
	public ResponseEntity<?> saveCartDetails(@RequestBody CartDetails cartDetails){
		Optional<CartDetails> optional = cartService.getCartById(cartDetails.getCartid());
		if (!optional.isPresent()) {
			Random random = new Random();
			cartDetails.setCartid(random.nextInt(1000));
			CartDetails cart = cartService.saveCartDetails(cartDetails);
			log.info("---Save Cart details---");
			return ResponseEntity.ok(cartDetails);
		}
		log.error("Id is already exist");
		throw new BadRequestException("Id is already exist");
	}
	
	@DeleteMapping("/delete/cartid/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer cartid) {
		Optional<CartDetails> optional = cartService.getCartById(cartid);
		if (!optional.isPresent()) {
			log.info("---Delete AddOn details---");
			cartService.deleteByCartId(cartid);
		} else {
			throw new BadRequestException("Id dosen't exist");
		}
		return ResponseEntity.ok(optional);
		
	}
	
	

}
