package com.example.spartafinalproject.model.dtos.moviessupport;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Awards{

	@JsonProperty("wins")
	private Integer wins;

	@JsonProperty("text")
	private String text;

	@JsonProperty("nominations")
	private Integer nominations;

	public Integer getWins(){
		return wins;
	}

	public String getText(){
		return text;
	}

	public Integer getNominations(){
		return nominations;
	}

	@Override
 	public String toString(){
		return 
			"Awards{" + 
			"wins = '" + wins + '\'' + 
			",text = '" + text + '\'' + 
			",nominations = '" + nominations + '\'' + 
			"}";
		}
}