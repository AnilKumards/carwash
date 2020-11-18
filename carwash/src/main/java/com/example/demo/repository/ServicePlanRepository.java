package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ServicePlan;

@Repository
public interface ServicePlanRepository extends MongoRepository<ServicePlan, Integer>{

	Optional<ServicePlan> findByServiceplanid(Integer serviceplanid);
	
	void deleteByServiceplanid(Integer serviceplanid);
}
