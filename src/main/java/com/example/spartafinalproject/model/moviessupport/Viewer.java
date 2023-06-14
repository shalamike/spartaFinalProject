package com.example.spartafinalproject.model.moviessupport;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Viewer{

	@JsonProperty("meter")
	private Integer meter;

	@JsonProperty("rating")
	private Integer rating;

	@JsonProperty("numReviews")
	private Integer numReviews;

	public Integer getMeter(){
		return meter;
	}

	public Integer getRating(){
		return rating;
	}

	public Integer getNumReviews(){
		return numReviews;
	}

	@Override
 	public String toString(){
		return 
			"Viewer{" + 
			"meter = '" + meter + '\'' + 
			",rating = '" + rating + '\'' + 
			",numReviews = '" + numReviews + '\'' + 
			"}";
		}
}