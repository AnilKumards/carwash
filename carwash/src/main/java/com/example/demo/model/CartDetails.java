package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Document(collection ="cartdetails")
@Data
public class CartDetails {
	
	@Override
	public String toString() {
		return "CartDetails [cartid=" + cartid + ", customer=" + customer + ", cartItem=" + cartItem + ", totalAmount="
				+ totalAmount + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartid;
	
	public Integer getCartid() {
		return cartid;
	}

	public void setCartid(Integer cartid) {
		this.cartid = cartid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@OneToOne
	@JoinColumn(name = "id")
	//@JsonIgnore
	private Customer customer;
	
	@OneToMany(mappedBy = "cartDetails", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CartItem> cartItem;
    
    @NotEmpty
    private Double totalAmount;
    
}
