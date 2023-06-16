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

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setNominations(Integer nominations) {
		this.nominations = nominations;
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