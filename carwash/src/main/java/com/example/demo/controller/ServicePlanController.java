package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.ServicePlan;
import com.example.demo.repository.ServicePlanRepository;
import com.example.demo.service.ServicePlanService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/api")
public class ServicePlanController {

	private static final Logger log = LoggerFactory.getLogger(ServicePlanController.class);
	@Autowired
	private ServicePlanService servicePlanService;
	
	@Autowired
	private ServicePlanRepository servicePlanRepository;
	
	@GetMapping("/serviceplan/splisting")
	public ResponseEntity<?> getAllServicePlan(){
		Map<Object, Object> spMap = new HashMap<Object, Object>();
		spMap.put("status", "success");
		spMap.put("data", servicePlanService.getAllServicePlan());
		log.info("---Fetching all the ServicePlan Details---");
		return ResponseEntity.ok(spMap);
	}
	
	@GetMapping("/serviceplan/spList")
	public ResponseEntity<?> getAllServicePlanList(){
		return ResponseEntity.ok(servicePlanService.getAllServicePlan());
	}
	
	
	@GetMapping("/serviceplan/{id}")
	public ResponseEntity<?> getPromoCodeById(@PathVariable("id") Integer serviceplanid){
		Optional<ServicePlan> spOptional = servicePlanRepository.findByServiceplanid(serviceplanid);
		log.info("---Searching for a SevicePlan with id {} ", serviceplanid);
		if(!spOptional.isPresent()) {
			log.error("Id "+ serviceplanid + " is not existed");
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(spOptional.get());
	}
	
	@PostMapping("/serviceplan/store")
	public ResponseEntity<?> storeServicePlanDetails(@RequestBody ServicePlan plan){
		Random random = new Random();
		plan.setServiceplanid(random.nextInt(1000));
		Optional<ServicePlan> spOptional = servicePlanService.getBySPId(plan.getServiceplanid());
		if(!spOptional.isPresent()) {
			ServicePlan sp = servicePlanRepository.save(plan);
			log.info("---Save ServicePlan details---");
			return ResponseEntity.ok(sp);
		}
		throw new BadRequestException("Id already exist");		
	}
	
	@DeleteMapping("/serviceplan/delete/{id}")
	public ResponseEntity<?> deleteBySPId(@PathVariable("id") Integer serviceplanid){
		Optional<ServicePlan> spOptional = servicePlanService.getBySPId(serviceplanid);
		if(!spOptional.isPresent()) {
			servicePlanRepository.deleteById(serviceplanid);
		}else {
			throw new BadRequestException("Id does not Exist");
		}
		log.info("---Delete ServicePlan details---");
		return ResponseEntity.ok(spOptional);
	}
	
}
