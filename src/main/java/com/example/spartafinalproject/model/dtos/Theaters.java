package com.example.spartafinalproject.model.dtos;

import com.example.spartafinalproject.model.dtos.theatersupport.Location;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("theaters")
public class Theaters{

	@JsonProperty("theaterId")
	private int theaterId;

	public Theaters(int theaterId, Location location, String id) {
		this.theaterId = theaterId;
		this.location = location;
		this.id = id;
	}

	public Theaters() {
	}

	@JsonProperty("location")
	private Location location;

	@JsonProperty("_id")
	private String id;

	public void setTheaterId(int theaterId){
		this.theaterId = theaterId;
	}

	public int getTheaterId(){
		return theaterId;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
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
			"Theaters{" + 
			"theaterId = '" + theaterId + '\'' + 
			",location = '" + location + '\'' + 
			",_id = '" + id + '\'' + 
			"}";
		}
}