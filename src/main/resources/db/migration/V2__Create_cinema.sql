CREATE TABLE IF NOT EXISTS movie(
	id INT NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	genre varchar(50),
	length int,
	
	CONSTRAINT pk_movie
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS cinema(
	id INT NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	address varchar(50) NOT NULL,
	
	CONSTRAINT pk_cinema
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS showtimes (
	id INT NOT NULL AUTO_INCREMENT,
	movie_id INT,
	cinema_id INT,
	begin_time DATETIME NOT NULL,
	
	CONSTRAINT pk_showtimes
	PRIMARY KEY (id),
	
	CONSTRAINT unique_showtimes
	UNIQUE (movie_id, cinema_id, begin_time),
	
	CONSTRAINT fk_showtimes_movie
	FOREIGN KEY (movie_id) REFERENCES movie(id),
	
	CONSTRAINT fk_showtimes_cinema
	FOREIGN KEY (cinema_id) REFERENCES cinema(id)
);


CREATE TABLE IF NOT EXISTS watch(
	user_id BIGINT,
	showtimes_id INT,
	
	CONSTRAINT pk_watch
	PRIMARY KEY (user_id, showtimes_id),
	
	CONSTRAINT fk_watch_user
	FOREIGN KEY (user_id) REFERENCES user(id),
	
	CONSTRAINT fk_watch_showtimes
	FOREIGN KEY (showtimes_id) REFERENCES showtimes(id)
);