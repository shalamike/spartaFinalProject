package com.example.spartafinalproject.model.moviessupport;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Imdb{

	@JsonProperty("rating")
	private Double rating;

	@JsonProperty("votes")
	private Integer votes;

	@JsonProperty("id")
	private Integer id;

	public Double getRating(){
		return rating;
	}

	public Integer getVotes(){
		return votes;
	}

	public Integer getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Imdb{" + 
			"rating = '" + rating + '\'' + 
			",votes = '" + votes + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}