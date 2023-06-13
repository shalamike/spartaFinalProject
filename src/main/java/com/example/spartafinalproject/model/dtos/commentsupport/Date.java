package com.example.spartafinalproject.model.dtos.commentsupport;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Date{

	@JsonProperty("$date")
	private String date;

	public String getDate(){
		return date;
	}

	@Override
 	public String toString(){
		return 
			"Date{" + 
			"$date = '" + date + '\'' + 
			"}";
		}
}