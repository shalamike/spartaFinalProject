package com.example.spartafinalproject.model.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("comments")
public class Comment{

	@JsonProperty("date")
	private Date date;

	@JsonProperty("name")
	private String name;

	@JsonProperty("_id")
	private String id;

	@JsonProperty("text")
	private String text;

	@JsonProperty("movie_id")
	private String movieId;

	@JsonProperty("email")
	private String email;

	public Date getDate(){
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public String getText(){
		return text;
	}

	public String getMovieId(){
		return movieId;
	}

	public String getEmail(){
		return email;
	}

	public Comment(Date date, String name, String id, String text, String movieId, String email) {
		this.date = date;
		this.name = name;
		this.id = id;
		this.text = text;
		this.movieId = movieId;
		this.email = email;
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