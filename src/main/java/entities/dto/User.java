package entities.dto;

import entities.dto.usersupport.Id;

public class User {
	private String password;
	private String name;
	private Id id;
	private String email;

	public String getPassword(){
		return password;
	}

	public String getName(){
		return name;
	}

	public Id getId(){
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
