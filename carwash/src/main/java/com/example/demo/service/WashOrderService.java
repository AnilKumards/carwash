package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.WashOrder;
import com.example.demo.repository.WashOrderRepository;

@Service
public class WashOrderService {
	
	@Autowired
	private WashOrderRepository washorderrepository;
	
 public WashOrder saveWashOrder(WashOrder washorder) {
	 washorder.setOrderstatus("Requested");
	 washorder.setOrderId(0);
		return washorderrepository.save(washorder);
	
}
 public WashOrder acceptOrder(WashOrder washorder)
 {
	
	 //WashOrder order=washorderrepository.findAll(washorder.getOrderId()).get();
	 //washorder.setWasherId(washorder.getWasherId());
	 washorder.setOrderstatus("In Progress");
	 return washorderrepository.save(washorder); 
 }
 public WashOrder serveOrder(WashOrder washorder)
 {
	return washorder;
	 /*WashOrder order=washorderrepository.findById(washorder.getOrderId()).get();
	 order.setOrderstatus("Served");
	 return washorderrepository.save(order); */
 }
 
}