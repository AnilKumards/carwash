package com.example.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "serviceplan")
public class ServicePlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer serviceplanid;
	
	@NotEmpty
	private String 	spname;
	
	@NotEmpty
	private Double price;

	public Integer getServiceplanid() {
		return serviceplanid;
	}

	public void setServiceplanid(Integer serviceplanid) {
		this.serviceplanid = serviceplanid;
	}

	public String getSpname() {
		return spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ServicePlan [serviceplanid=" + serviceplanid + ", spname=" + spname + ", price=" + price + "]";
	}
	
}
