package com.example.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "washorder")
public class WashOrder {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String orderstatus;
	private String packageId;
	private String date;
	private String time;
	private String location;
	
	private String carModel;
	private String carNumber;
	
	@Override
	public String toString() {
		return "WashOrder [orderId=" + orderId + ", orderstatus=" + orderstatus + ", packageId=" + packageId + ", date="
				+ date + ", time=" + time + ", location=" + location + ", carModel=" + carModel + ", carNumber="
				+ carNumber + ", customerId=" + customerId + ", washerId=" + washerId + "]";
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getWasherId() {
		return washerId;
	}
	public void setWasherId(String washerId) {
		this.washerId = washerId;
	}
	private String customerId;
	private String washerId;
	
}
