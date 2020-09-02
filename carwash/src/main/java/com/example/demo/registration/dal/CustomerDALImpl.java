package com.example.demo.registration.dal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;
import com.example.demo.model.Role;

@Repository
public class CustomerDALImpl implements CustomerDAL {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	

	@Override
	public Customer getById(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("Email").is(userId));
		return mongoTemplate.findOne(query, Customer.class);
		// TODO Auto-generated method stub
	}


	@Override
	public Set<Role> getRole() {
		// TODO Auto-generated method stub
		List<Role> role=mongoTemplate.findAll(Role.class);
		Set<Role> setRole=new HashSet<Role>(role);
		return setRole;
		
	}


	/*@Override
	public Customer getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Customer getPassword(String password) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	
	

}
