package com.example.demo.registration.dal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.example.demo.model.Role;
import com.example.demo.model.Washer;

public class WasherDALImpl implements WasherDAL{
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public Washer getById(String userId) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("Email").is(userId));
		return mongoTemplate.findOne(query, Washer.class);
	}

	@Override
	public Set<Role> getRole() {
		// TODO Auto-generated method stub
		List<Role> role=mongoTemplate.findAll(Role.class);
		Set<Role> setRole=new HashSet<Role>(role);
		return setRole;
	}

}
