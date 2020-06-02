package com.example.demo.payload.response.sales;

public class CinemaReport {
	
	private Integer id;
	
	private String name;
	
	private Long sales;
	
	public CinemaReport() {
		super();
	}
	
	public CinemaReport(Integer id, String name, Long sales) {
		super();
		this.id = id;
		this.name = name;
		this.sales = sales;
	}
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
	public Long getSales() {
		return sales;
	}
	public void setSales(Long sales) {
		this.sales = sales;
	}
	
}
