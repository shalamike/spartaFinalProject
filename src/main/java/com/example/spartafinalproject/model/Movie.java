package com.example.spartafinalproject.model;

import java.util.Date;
import java.util.List;

import com.example.spartafinalproject.model.moviessupport.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("movies")
public class Movie {

	@Id
	@JsonProperty("_id")
	private String id;

	@JsonProperty("year")
	private Integer year;

	@JsonProperty("directors")
	private List<String> directors;

	@JsonProperty("runtime")
	private Integer runtime;

	@JsonProperty("countries")
	private List<String> countries;

	@JsonProperty("num_mflix_comments")
	private Integer numMflixComments;

	@JsonProperty("title")
	private String title;

	@JsonProperty("type")
	private String type;

	@JsonProperty("rated")
	private String rated;

	@JsonProperty("cast")
	private List<String> cast;

	@JsonProperty("tomatoes")
	private Tomatoes tomatoes;

	@JsonProperty("fullplot")
	private String fullplot;

	@JsonProperty("imdb")
	private Imdb imdb;

	@JsonProperty("plot")
	private String plot;

	@JsonProperty("genres")
	private List<String> genres;

	@JsonProperty("awards")
	private Awards awards;

	@JsonProperty("lastupdated")
	private String lastupdated;


	@JsonProperty("released")
	private Date released;

	public Integer getYear(){
		return year;
	}

	public List<String> getDirectors(){
		return directors;
	}

	public Integer getRuntime(){
		return runtime;
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

	public Date getReleased(){
		return released;
	}

	public Movie(String id, Integer year, List<String> directors, Integer runtime, List<String> countries, Integer numMflixComments, String title, String type, String rated, List<String> cast, Tomatoes tomatoes, String fullplot, Imdb imdb, String plot, List<String> genres, Awards awards, String lastupdated, Date released) {
		this.id = id;
		this.year = year;
		this.directors = directors;
		this.runtime = runtime;
		this.countries = countries;
		this.numMflixComments = numMflixComments;
		this.title = title;
		this.type = type;
		this.rated = rated;
		this.cast = cast;
		this.tomatoes = tomatoes;
		this.fullplot = fullplot;
		this.imdb = imdb;
		this.plot = plot;
		this.genres = genres;
		this.awards = awards;
		this.lastupdated = lastupdated;
		this.released = released;
	}

	@Override
 	public String toString(){
		return 
			"Movies{" + 
			"year = '" + year + '\'' + 
			",directors = '" + directors + '\'' + 
			",runtime = '" + runtime + '\'' + 
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
			",released = '" + released + '\'' + 
			"}";
		}
}