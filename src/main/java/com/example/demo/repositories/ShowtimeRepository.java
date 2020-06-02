package com.example.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Showtime;
import com.example.demo.payload.response.sales.CinemaReport;

public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {
	
	@Query("SELECT NEW com.example.demo.payload.response.sales.CinemaReport(c.id, c.name, COUNT(w))"
			+ " FROM Cinema c"
			+ " JOIN c.showtimes s"
			+ " JOIN s.audiences w"
			+ " WHERE s.beginTime >= :dateBegin"
			+ " AND s.beginTime < :dateEnd"
			+ " GROUP BY c")
	public List<CinemaReport> report(@Param("dateBegin") Date dateBegin, @Param("dateEnd") Date dateEnd);
	
}
