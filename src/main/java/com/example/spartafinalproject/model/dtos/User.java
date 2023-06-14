package com.example.spartafinalproject.model.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("users")
public class User {

	private String password;

	private String name;
	@Id
	@JsonProperty("_id")
	private String id;

	private String email;

	public String getPassword(){
		return password;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"password = '" + password + '\'' + 
			",name = '" + name + '\'' + 
			",_id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}
