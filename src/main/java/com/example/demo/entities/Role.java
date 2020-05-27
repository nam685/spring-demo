package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jdk.jfr.Unsigned;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	@Unsigned
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;

	public Role(Integer id, ERole name) {
		this.id = id;
		this.name = name;
	}
	
	public Role() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}
}
