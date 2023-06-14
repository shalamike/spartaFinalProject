package com.example.spartafinalproject.model.dtos.sessionssupport;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Id{

	@JsonProperty("$oid")
	private String oid;

	public void setOid(String oid){
		this.oid = oid;
	}

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