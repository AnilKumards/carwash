package com.example.demo.model;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection ="tbl_custreview")
public class CustomerReviews {

	@Id
	private String cust_review_id;
	
	@NotEmpty
	private String comments;
	
	@NotEmpty
	private Integer rating;
}
