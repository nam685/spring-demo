package com.example.demo.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.payload.response.sales.DayReportResponse;
import com.example.demo.repositories.ShowtimeRepository;

@Service
public class ReportService {

	@Autowired
	private ShowtimeRepository showtimeRepository;

	public DayReportResponse getDayReport(String dateString) {
		Date date = getDate(dateString);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -1);
		Date yesterday = cal.getTime();
		
		return new DayReportResponse(showtimeRepository.report(yesterday, date));
	}
	
	private Date getDate(String dateString) {

		Date now = new Date(System.currentTimeMillis());
		Date date = now;
		
		// if fail, use current time by default
		
		try {
			if (dateString != null) {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
				
				if (date.compareTo(now) > 0) {
					date = now;
				}
			}
		}
		catch (ParseException e) {
			// no need to do anything
			System.out.println("Can't parse this string into Date.\n");
		}
		
		return date;
	}
}
