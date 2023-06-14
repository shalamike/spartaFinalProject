package com.example.spartafinalproject.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sessions{

	@JsonProperty("user_id")
	private String userId;

	@JsonProperty("jwt")
	private String jwt;

	@JsonProperty("_id")
	private String id;

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setJwt(String jwt){
		this.jwt = jwt;
	}

	public String getJwt(){
		return jwt;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Sessions{" + 
			"user_id = '" + userId + '\'' + 
			",jwt = '" + jwt + '\'' + 
			",_id = '" + id + '\'' + 
			"}";
		}
}