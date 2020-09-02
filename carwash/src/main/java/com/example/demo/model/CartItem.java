package com.example.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Document(collection ="cartitem")
@Data
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartItemId;
	
	public Integer getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(Integer cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@NotEmpty
	private Integer quantity;
	
	@NotEmpty
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "cartid")
	@JsonIgnore
	private CartDetails cartDetails;

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", quantity=" + quantity + ", price=" + price + ", cartDetails="
				+ cartDetails + "]";
	}
}
