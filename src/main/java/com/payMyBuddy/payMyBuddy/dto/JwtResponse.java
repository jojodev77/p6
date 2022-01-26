package com.payMyBuddy.payMyBuddy.dto;

import lombok.Data;

@Data
public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String lastName;
	private String email;
	public JwtResponse(String accessToken, Long id, String username, String email) {
		this.token = accessToken;
		this.id = id;
		this.lastName = lastName;
		this.email = email;
	}

}
