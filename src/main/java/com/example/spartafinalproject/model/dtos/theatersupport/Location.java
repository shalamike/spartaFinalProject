package com.example.spartafinalproject.model.dtos.theatersupport;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location{

	@JsonProperty("geo")
	private Geo geo;

	@JsonProperty("address")
	private Address address;

	public void setGeo(Geo geo){
		this.geo = geo;
	}

	public Geo getGeo(){
		return geo;
	}

	public void setAddress(Address address){
		this.address = address;
	}

	public Address getAddress(){
		return address;
	}

	@Override
 	public String toString(){
		return 
			"Location{" + 
			"geo = '" + geo + '\'' + 
			",address = '" + address + '\'' + 
			"}";
		}
}