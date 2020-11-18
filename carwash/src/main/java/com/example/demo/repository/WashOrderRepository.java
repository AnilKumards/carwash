package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.WashOrder;
import com.google.common.base.Optional;
@Repository
public interface WashOrderRepository extends MongoRepository<WashOrder, Integer> {
	
	List<WashOrder> findAll();

	WashOrder save(WashOrder washorder);
	
	//Optional<WashOrder> findByWashid(Integer washid);

}
