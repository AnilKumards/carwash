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

import com.example.demo.model.Role;
import com.example.demo.model.Washer;
import com.example.demo.registration.dal.WasherDAL;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.WasherRepository;

public class WasherLoginService {


	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private WasherRepository repo;
	
	@Autowired
	private Washer washer;
	
	@Autowired
	private WasherDAL washerDal;
	
	public Washer saveWasher(Washer washer)
	{
		Role userRole = roleRepository.findByRole("ADMIN");
	    washer.setRoles(new HashSet<>(Arrays.asList(userRole)));
	    System.out.println("userrole is " + userRole);
		return repo.save(washer);
	}
	
	
	public Washer getById(String userId)
	{
		return washerDal.getById(userId);
	}
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		   // Customer customer = repo.findByEmail(email);
		    Washer washer =washerDal.getById(email);
		    if(washer != null) {
		        List<GrantedAuthority> authorities = getUserAuthority(washer.getRoles());
		        return buildUserForAuthentication(washer, authorities);
		    } else {
		        throw new UsernameNotFoundException("username not found");
		    }
		}


	private UserDetails buildUserForAuthentication(Washer washer, List<GrantedAuthority> authorities) {
		// TODO Auto-generated method stub
		return new org.springframework.security.core.userdetails.User(washer.getEmail(), washer.getPassword(), authorities);
	}


	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
		// TODO Auto-generated method stub
		Set<GrantedAuthority> roles = new HashSet<>();
	    userRoles.forEach((role) -> {
	        roles.add(new SimpleGrantedAuthority(role.getRole()));
	    });

	    List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
	    return grantedAuthorities;
	}
	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Object getByEmail()
	{
		return null;
	}	
	}
	

