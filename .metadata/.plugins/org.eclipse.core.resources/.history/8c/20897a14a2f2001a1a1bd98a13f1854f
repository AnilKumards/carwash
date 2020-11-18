package com.capgemini.carwash.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.carwash.entity.ServicePlan;
import com.capgemini.carwash.repository.ServicePlanRepository;
import com.capgemini.carwash.service.ServicePlanService;

@Service
public class ServicePlanServiceImpl implements ServicePlanService{

	@Autowired
	private ServicePlanRepository servicePlanRepository;
	
	@Override
	public List<ServicePlan> getAllServicePlan() {
		return servicePlanRepository.findAll();
	}

	@Override
	public Optional<ServicePlan> getBySPId(Integer serviceplanid) {
		Optional<ServicePlan> sp = servicePlanRepository.findByServiceplanid(serviceplanid);
		return sp;
	}

	
}
