package com.example.demo.payload.response.sales;

import java.util.List;

public class DayReportResponse {

	List<CinemaReport> cinemaReports;

	public DayReportResponse(List<CinemaReport> cinemaReports) {
		super();
		this.cinemaReports = cinemaReports;
	}

	public List<CinemaReport> getCinemaReports() {
		return cinemaReports;
	}

	public void setCinemaReports(List<CinemaReport> cinemaReports) {
		this.cinemaReports = cinemaReports;
	}
	
}
