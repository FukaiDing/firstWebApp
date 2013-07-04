package com.dodopipe.beans;

public class Userbean{
	private String username;
	private String password;
	private String role;

	public Userbean(String username,String password,String role){
		this.username = username;
		this.password =password;
		this.role = role;
	}

	public Userbean(){
		
	}

	public String getUsername(){
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getRole(){
		return role;
	}

	public void setRole(String role){
		this.role = role;
	}
}