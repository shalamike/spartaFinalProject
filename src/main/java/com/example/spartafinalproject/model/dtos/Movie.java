package com.example.spartafinalproject.model.dtos;

import com.example.spartafinalproject.model.dtos.moviessupport.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Document("movies")
public class Movie {
    @Id
    @JsonProperty("_id")
    private String id;
    @NotNull
    private String title;
    @NotNull
    private Integer year;
    @NotNull
    private String type;

    @Field("num_mflix_comments")
    private Integer numMflixComments;
    private List<String> directors;
    private List<String> cast;
    private List<String> languages;
    private Integer runtime;
    private List<String> writers;
    private List<String> countries;
    private String rated;
    private Tomatoes tomatoes;
    private String fullplot;
    private Imdb imdb;
    private String plot;
    private List<String> genres;
    private Awards awards;
    private String lastupdated;
    private String poster;
    private Date released;

    public Movie() {
    }

    public Movie(@NotNull String title, @NotNull Integer year, @NotNull String type) {
        this.title = title;
        this.year = year;
        this.type = type;
        this.numMflixComments=0;//default value is 0
    }

    public List<String> getLanguages() {
        return languages;
    }

    public Integer getYear() {
        return year;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public List<String> getWriters() {
        return writers;
    }

    public List<String> getCountries() {
        return countries;
    }

    public Integer getNumMflixComments() {
        return numMflixComments;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getRated() {
        return rated;
    }

    public List<String> getCast() {
        return cast;
    }

    public Tomatoes getTomatoes() {
        return tomatoes;
    }

    public String getFullplot() {
        return fullplot;
    }

    public Imdb getImdb() {
        return imdb;
    }

    public String getPlot() {
        return plot;
    }

    public List<String> getGenres() {
        return genres;
    }

    public Awards getAwards() {
        return awards;
    }

    public String getLastupdated() {
        return lastupdated;
    }

    public String getId() {
        return id;
    }

    public String getPoster() {
        return poster;
    }

    public Date getReleased() {
        return released;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumMflixComments(Integer numMflixComments) {
        this.numMflixComments = numMflixComments;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public void setTomatoes(Tomatoes tomatoes) {
        this.tomatoes = tomatoes;
    }

    public void setFullplot(String fullplot) {
        this.fullplot = fullplot;
    }

    public void setImdb(Imdb imdb) {
        this.imdb = imdb;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public void setAwards(Awards awards) {
        this.awards = awards;
    }

    public void setLastupdated(String lastupdated) {
        this.lastupdated = lastupdated;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    @Override
    public String toString() {
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