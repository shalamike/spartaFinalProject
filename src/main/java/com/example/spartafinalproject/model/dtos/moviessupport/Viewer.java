package com.example.spartafinalproject.model.dtos.moviessupport;


public class Viewer{
	private Integer meter;
	private Double rating;
	private Integer numReviews;

	public Integer getMeter(){
		return meter;
	}

	public Double getRating(){
		return rating;
	}

	public Integer getNumReviews(){
		return numReviews;
	}

	public void setMeter(Integer meter) {
		this.meter = meter;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public void setNumReviews(Integer numReviews) {
		this.numReviews = numReviews;
	}

	@Override
 	public String toString(){
		return 
			"Viewer{" + 
			"meter = '" + meter + '\'' + 
			",rating = '" + rating + '\'' + 
			",numReviews = '" + numReviews + '\'' + 
			"}";
		}
}