package com.example.spartafinalproject.model;

import com.example.spartafinalproject.model.moviessupport.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document("movies")
public class Movie {
	@Id
	@JsonProperty("_id")
	private String id;
	private List<String> languages;
	private Integer year;
	private List<String> directors;
	private Integer runtime;
	private List<String> writers;
	private List<String> countries;
	@Field("num_mflix_comments")
	private Integer numMflixComments;

//	@JsonProperty("title")
	private String title;

//	@JsonProperty("type")
	private String type;

//	@JsonProperty("rated")
	private String rated;

//	@JsonProperty("cast")
	private List<String> cast;

//	@JsonProperty("tomatoes")
	private Tomatoes tomatoes;

//	@JsonProperty("fullplot")
	private String fullplot;

//	@JsonProperty("imdb")
	private Imdb imdb;

//	@JsonProperty("plot")
	private String plot;

//	@JsonProperty("genres")
	private List<String> genres;

//	@JsonProperty("awards")
	private Awards awards;

//	@JsonProperty("lastupdated")
	private String lastupdated;

//	@JsonProperty("poster")
	private String poster;

//	@JsonProperty("released")
	private Date released;

	public List<String> getLanguages(){
		return languages;
	}

	public Integer getYear(){
		return year;
	}

	public List<String> getDirectors(){
		return directors;
	}

	public Integer getRuntime(){
		return runtime;
	}

	public List<String> getWriters(){
		return writers;
	}

	public List<String> getCountries(){
		return countries;
	}

	public Integer getNumMflixComments(){
		return numMflixComments;
	}

	public String getTitle(){
		return title;
	}

	public String getType(){
		return type;
	}

	public String getRated(){
		return rated;
	}

	public List<String> getCast(){
		return cast;
	}

	public Tomatoes getTomatoes(){
		return tomatoes;
	}

	public String getFullplot(){
		return fullplot;
	}

	public Imdb getImdb(){
		return imdb;
	}

	public String getPlot(){
		return plot;
	}

	public List<String> getGenres(){
		return genres;
	}

	public Awards getAwards(){
		return awards;
	}

	public String getLastupdated(){
		return lastupdated;
	}

	public String getId(){
		return id;
	}

	public String getPoster(){
		return poster;
	}

	public Date getReleased(){
		return released;
	}

	@Override
 	public String toString(){
		return
			"Movie{" +
			"languages = '" + languages + '\'' +
			",year = '" + year + '\'' +
			",directors = '" + directors + '\'' +
			",runtime = '" + runtime + '\'' +
			",writers = '" + writers + '\'' +
			",countries = '" + countries + '\'' +
			",num_mflix_comments = '" + numMflixComments + '\'' +
			",title = '" + title + '\'' +
			",type = '" + type + '\'' +
			",rated = '" + rated + '\'' +
			",cast = '" + cast + '\'' +
			",tomatoes = '" + tomatoes + '\'' +
			",fullplot = '" + fullplot + '\'' +
			",imdb = '" + imdb + '\'' +
			",plot = '" + plot + '\'' +
			",genres = '" + genres + '\'' +
			",awards = '" + awards + '\'' +
			",lastupdated = '" + lastupdated + '\'' +
			",_id = '" + id + '\'' +
			",poster = '" + poster + '\'' +
			",released = '" + released + '\'' +
			"}";
		}
}