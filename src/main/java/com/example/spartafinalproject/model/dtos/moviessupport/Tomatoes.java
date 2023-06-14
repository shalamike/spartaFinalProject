package com.example.spartafinalproject.model.dtos.moviessupport;

import java.util.Date;

public class Tomatoes{
	private Viewer viewer;
	private Date lastUpdated;

	public Viewer getViewer(){
		return viewer;
	}

	public Date getLastUpdated(){
		return lastUpdated;
	}

	@Override
 	public String toString(){
		return 
			"Tomatoes{" + 
			"viewer = '" + viewer + '\'' + 
			",lastUpdated = '" + lastUpdated + '\'' + 
			"}";
		}
}