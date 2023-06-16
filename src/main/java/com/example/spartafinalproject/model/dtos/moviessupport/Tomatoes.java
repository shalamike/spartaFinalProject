package com.example.spartafinalproject.model.dtos.moviessupport;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Tomatoes{
	private Viewer viewer;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date lastUpdated;

	public Viewer getViewer(){
		return viewer;
	}

	public Date getLastUpdated(){
		return lastUpdated;
	}

	public void setViewer(Viewer viewer) {
		this.viewer = viewer;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
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