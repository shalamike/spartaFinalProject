package com.example.spartafinalproject.model.dtos.moviessupport;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Awards{

	private Integer wins;
	private String text;
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