INSERT IGNORE INTO movie VALUES (1, "Batman", "Action", 112);
INSERT IGNORE INTO movie VALUES (2, "Spirited Away", "Anime", 125);
INSERT IGNORE INTO movie VALUES (3, "Naruto Ep.97", "Anime", 20);
INSERT IGNORE INTO movie VALUES (4, "Up", "Animated", 120);
INSERT IGNORE INTO movie VALUES (5, "The Godfather", "Action", 150);

INSERT IGNORE INTO cinema VALUES (1, "Rap Thang Tam", "12 Pho Hue");
INSERT IGNORE INTO cinema VALUES (2, "Cinema du Pantheon", "34 Avenue d'Ivry");

INSERT IGNORE INTO showtimes VALUES (1, 1, 1, "2020-01-23");
INSERT IGNORE INTO showtimes VALUES (2, 1, 1, "2019-12-25");
INSERT IGNORE INTO showtimes VALUES (3, 1, 1, "2020-02-14");
INSERT IGNORE INTO showtimes VALUES (4, 1, 1, "2020-03-10");
INSERT IGNORE INTO showtimes VALUES (5, 2, 2, "2018-08-23");
INSERT IGNORE INTO showtimes VALUES (6, 3, 2, "2020-05-29");
INSERT IGNORE INTO showtimes VALUES (7, 3, 2, "2020-01-02");
INSERT IGNORE INTO showtimes VALUES (8, 5, 2, "2020-04-30");
INSERT IGNORE INTO showtimes VALUES (9, 4, 1, "2020-05-29");
INSERT IGNORE INTO showtimes VALUES (10, 5, 2, "2020-01-02");

INSERT IGNORE INTO watch VALUES (9, 2);
INSERT IGNORE INTO watch VALUES (9, 8);
INSERT IGNORE INTO watch VALUES (10, 4);
INSERT IGNORE INTO watch VALUES (13, 5);
INSERT IGNORE INTO watch VALUES (13, 1);
INSERT IGNORE INTO watch VALUES (10, 9);