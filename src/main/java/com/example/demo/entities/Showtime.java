package com.example.demo.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="showtimes")
public class Showtime {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@MapsId("movie_id")
	private Movie movie;

	@ManyToOne
	@MapsId("cinema_id")
	private Cinema cinema;
	
	@Column
	private Date beginTime;
	
	@ManyToMany(mappedBy = "watchHistory")
	@JsonIgnore
	private Set<User> audiences = new HashSet<>();
	
	public Showtime() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Set<User> getAudiences() {
		return audiences;
	}

	public void setAudiences(Set<User> audiences) {
		this.audiences = audiences;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	
}
