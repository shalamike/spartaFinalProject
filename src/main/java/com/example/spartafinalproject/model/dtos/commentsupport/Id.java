package com.example.spartafinalproject.model.dtos.commentsupport;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Id{

	@JsonProperty("$oid")
	private String oid;

	public String getOid(){
		return oid;
	}

	@Override
 	public String toString(){
		return 
			"Id{" + 
			"$oid = '" + oid + '\'' + 
			"}";
		}
}