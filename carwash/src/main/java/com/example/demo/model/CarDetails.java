package com.example.demo.model;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.NaturalId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "car details")
public class CarDetails {

	@Id
    private Integer car_id;

    @NaturalId
    @NotEmpty
    private String car_number;
    
    @NotEmpty
    private String car_type;
    
    @NotEmpty
    private String color;
    
    @NotEmpty
    private String reg_number;
}
