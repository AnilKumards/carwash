package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.WashOrder;
import com.example.demo.service.WashOrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api")
@CrossOrigin
public class WashOrderController {
	
	private static final Logger log = LoggerFactory.getLogger(WashOrderController.class);
	@Autowired
	private WashOrderService washorderservice;
	
	@PostMapping("/saveWashOrder")
		public WashOrder saveWashOrder(@RequestBody WashOrder washorder)
		{
		System.out.println(washorder);
		return washorderservice.saveWashOrder(washorder);
		}
	@PostMapping("/acceptOrder")
	public WashOrder acceptOrder(@RequestBody WashOrder washorder)
	{
	System.out.println(washorder);
	return washorderservice.acceptOrder(washorder);
	}
}
