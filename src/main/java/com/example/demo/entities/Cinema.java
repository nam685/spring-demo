package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cinema {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false, unique = true, length = 50)
	private String name;
	
	@Column(nullable = false, unique = true, length = 50)
	private String address;
	
	@OneToMany(mappedBy = "cinema"/*, fetch = FetchType.EAGER just 4fun*/)
	@JsonIgnore
	private Set<Showtime> showtimes = new HashSet<>();
	
	public Cinema() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Showtime> getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(Set<Showtime> showtimes) {
		this.showtimes = showtimes;
	}
	
	
	
	
}
