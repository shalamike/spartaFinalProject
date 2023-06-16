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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(String id, String name, String password, String email) {
		this.password = password;
		this.name = name;
		this.id = id;
		this.email = email;
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
