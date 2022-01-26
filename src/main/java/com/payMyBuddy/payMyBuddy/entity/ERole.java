package com.payMyBuddy.payMyBuddy.entity;

import java.util.HashMap;
import java.util.Map;



public enum ERole {
	ROLE_CLIENT("CLIENT"),
	ROLE_CLIENTVIP("CLIENTVIP"), 
	ROLE_BANK("BANK");


	private String content;

	private static Map<String,ERole> roles = new HashMap<>();

	ERole(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	static
	{
		for(ERole en : ERole.values())
		{
			roles.put(en.getContent(), en);
		}
	}

	public static ERole getName(String content) 
	{
		return roles.get(content);
	}

}

