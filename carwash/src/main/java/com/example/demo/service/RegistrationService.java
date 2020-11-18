package com.example.demo.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.registration.dal.CustomerDAL;
import com.example.demo.model.Customer;
import com.example.demo.model.Role;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RoleRepository;

@Service
public class RegistrationService  {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private CustomerDAL customerDal;
	
	public Customer saveCustomer(Customer customer)
	{
		Role userRole = roleRepository.findByRole("ADMIN");
	    customer.setRoles(new HashSet<>(Arrays.asList(userRole)));
	    System.out.println("userrole is " + userRole);
		return repo.save(customer);
	}
	
	
	public Customer getById(String userId)
	{
		return customerDal.getById(userId);
	}
	/*public Customer getByEmail(String email)
	{
		return customerDal.getByEmail(email);
	}
	public Customer getPassword(String password)
	{
		return customerDal.getPassword(password);
	}*/
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

	   // Customer customer = repo.findByEmail(email);
	    Customer customer =customerDal.getById(email);
	    if(customer != null) {
	        List<GrantedAuthority> authorities = getUserAuthority(customer.getRoles());
	        return buildUserForAuthentication(customer, authorities);
	    } else {
	        throw new UsernameNotFoundException("username not found");
	    }
	}
	
	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
	    Set<GrantedAuthority> roles = new HashSet<>();
	    userRoles.forEach((role) -> {
	        roles.add(new SimpleGrantedAuthority(role.getRole()));
	    });

	    List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
	    return grantedAuthorities;
	}
	
	private UserDetails buildUserForAuthentication(Customer customer, List<GrantedAuthority> authorities) {
	    return new org.springframework.security.core.userdetails.User(customer.getEmail(), customer.getPassword(), authorities);
	}


	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Object getByEmail()
	{
		return null;
	}	
	
	
	/*
	public String fetchCustomerByEmail(String email) {
		return repo.findByEmail(email);
	}
	*/

}
