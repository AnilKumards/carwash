package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ServicePlan;
import com.example.demo.repository.ServicePlanRepository;

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
