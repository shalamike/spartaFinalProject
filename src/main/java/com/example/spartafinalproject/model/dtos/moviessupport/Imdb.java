package com.example.spartafinalproject.model.dtos.moviessupport;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.mongodb.core.mapping.Field;

public class Imdb{
	private Double rating;
	private Integer votes;

	@Field("id")
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

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public void setId(Integer id) {
		this.id = id;
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