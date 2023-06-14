package com.example.spartafinalproject.model.theatersupport;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Geo{

	@JsonProperty("coordinates")
	private List<Double> coordinates;

	@JsonProperty("type")
	private String type;

	public void setCoordinates(List<Double> coordinates){
		this.coordinates = coordinates;
	}

	public List<Double> getCoordinates(){
		return coordinates;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"Geo{" + 
			"coordinates = '" + coordinates + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}