package com.example.demo.payload;

import lombok.Data;

@Data
public class AuthToken {

	private String token;
	private String username;
	
	public AuthToken(String token, String username){
        this.token = token;
        this.username = username;
    }
}
