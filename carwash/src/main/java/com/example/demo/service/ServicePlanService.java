package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import com.example.demo.model.ServicePlan;
public interface ServicePlanService {

	List<ServicePlan> getAllServicePlan();
	
	Optional<ServicePlan> getBySPId(Integer serviceplanid);
}
