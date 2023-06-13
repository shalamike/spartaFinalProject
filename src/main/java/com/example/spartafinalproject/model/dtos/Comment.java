package com.example.spartafinalproject.model.dtos;

import com.example.spartafinalproject.model.dtos.commentsupport.Date;
import com.example.spartafinalproject.model.dtos.commentsupport.Id;
import com.example.spartafinalproject.model.dtos.commentsupport.MovieId;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("comments")
public class Comment{

	@JsonProperty("date")
	private Date date;

	@JsonProperty("name")
	private String name;

	@org.springframework.data.annotation.Id
	@JsonProperty("_id")
	private Id id;

	@JsonProperty("text")
	private String text;

	@JsonProperty("movie_id")
	private MovieId movieId;

	@JsonProperty("email")
	private String email;

	public Date getDate(){
		return date;
	}

	public String getName(){
		return name;
	}

	public Id getId(){
		return id;
	}

	public String getText(){
		return text;
	}

	public MovieId getMovieId(){
		return movieId;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"date = '" + date + '\'' + 
			",name = '" + name + '\'' + 
			",_id = '" + id + '\'' + 
			",text = '" + text + '\'' + 
			",movie_id = '" + movieId + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}