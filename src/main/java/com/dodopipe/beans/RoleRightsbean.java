package com.dodopipe.beans;

public class RoleRightsbean{

	private int id;
	private String role;
	private String rights;
	private String url;
	private String params;

	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}

	public void setRole(String role){
		this.role = role;
	}
	public String getRole(){
		return role;
	}

	public void setRights(String rights){
		this.rights = rights;
	}
	public String getRights(){
		return rights;
	}

	public void setUrl(String url){
		this.url = url;
	}
	public String getUrl(){
		return url;
	}

	public void setParams(String params){
		this.params = params;
	}
	public String getParams(){
		return params;
	}

}