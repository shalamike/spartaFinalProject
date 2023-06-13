package com.example.spartafinalproject.model.dtos.commentsupport;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieId{

	@JsonProperty("$oid")
	private String oid;

	public String getOid(){
		return oid;
	}

	@Override
 	public String toString(){
		return 
			"MovieId{" + 
			"$oid = '" + oid + '\'' + 
			"}";
		}
}