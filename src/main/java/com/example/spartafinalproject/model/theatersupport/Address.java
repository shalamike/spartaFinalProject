package com.example.spartafinalproject.model.theatersupport;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address{

	@JsonProperty("zipcode")
	private String zipcode;

	@JsonProperty("city")
	private String city;

	@JsonProperty("street1")
	private String street1;

	@JsonProperty("state")
	private String state;

	public void setZipcode(String zipcode){
		this.zipcode = zipcode;
	}

	public String getZipcode(){
		return zipcode;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setStreet1(String street1){
		this.street1 = street1;
	}

	public String getStreet1(){
		return street1;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	@Override
 	public String toString(){
		return 
			"Address{" + 
			"zipcode = '" + zipcode + '\'' + 
			",city = '" + city + '\'' + 
			",street1 = '" + street1 + '\'' + 
			",state = '" + state + '\'' + 
			"}";
		}
}