--DEREK STATHIS
--TERM PROJECT
--INITIALIZE TABLES WITH DATA
INSERT INTO OLYMPICS (olympic_num, host_city, opening_date, closing_date, official_website) VALUES ('I', 'Beijing', '01-APR-19', '01-APR-19', 'www.Beijing.com');
INSERT INTO OLYMPICS (olympic_num, host_city, opening_date, closing_date, official_website) VALUES ('II', 'London', '01-APR-19', '01-APR-19', 'www.London.com');
INSERT INTO OLYMPICS (olympic_num, host_city, opening_date, closing_date, official_website) VALUES ('III', 'Athens', '01-APR-19', '01-APR-19', 'www.Athens.com');
INSERT INTO OLYMPICS (olympic_num, host_city, opening_date, closing_date, official_website) VALUES ('VI', 'Rio', '01-APR-19', '01-APR-19', 'www.Rio.com');

INSERT INTO SPORT (sport_name, description, dob, team_size) VALUES ('Basketball', 'The sport of basketball', '01-APR-19', 10);
INSERT INTO SPORT (sport_name, description, dob, team_size) VALUES ('Baseball', 'The sport of baseball', '01-APR-19', 30);
INSERT INTO SPORT (sport_name, description, dob, team_size) VALUES ('Soccer', 'The sport of soccer','01-APR-19', 25);
INSERT INTO SPORT (sport_name, description, dob, team_size) VALUES ('Wrestling', 'The sport of wrestling', '01-APR-19', 1);
INSERT INTO SPORT (sport_name, description, dob, team_size) VALUES ('Boxing', 'The sport of boxing','01-APR-19', 1);
INSERT INTO SPORT (sport_name, description, dob, team_size) VALUES ('Diving', 'The sport of diving', '01-APR-19', 1);

INSERT INTO COUNTRY (country, country_code) VALUES ('America', 'USA');
INSERT INTO COUNTRY (country, country_code) VALUES ('China', 'CHI');

INSERT INTO TEAM (olympic_id, team_name, country_id, sport_id, coach_id) VALUES (1, 'China Basketball',2,1,1);
INSERT INTO TEAM (olympic_id, team_name, country_id, sport_id, coach_id) VALUES (1, 'United States Basketball',1,1,2);
INSERT INTO TEAM (olympic_id, team_name, country_id, sport_id, coach_id) VALUES (1, 'United States soccer',1, 3,3);
INSERT INTO TEAM (olympic_id, team_name, country_id, sport_id, coach_id) VALUES (2, 'China diving',2,6,4);
INSERT INTO TEAM (olympic_id, team_name, country_id, sport_id, coach_id) VALUES (2, 'United States Wrestling',1,4,5);
INSERT INTO TEAM (olympic_id, team_name, country_id, sport_id, coach_id) VALUES (2, 'China Boxing',2,5,6);

INSERT INTO PARTICIPANT (fname, lname, nationality, birth_place, dob) VALUES('Joe1', 'Smith', 'A', 'A','01-APR-19');
INSERT INTO PARTICIPANT (fname, lname, nationality, birth_place, dob) VALUES('Joe2', 'Smith', 'B', 'B','01-APR-19');
INSERT INTO PARTICIPANT (fname, lname, nationality, birth_place, dob) VALUES('Joe3', 'Smith', 'C', 'C','01-APR-19');
INSERT INTO PARTICIPANT (fname, lname, nationality, birth_place, dob) VALUES('Joe4', 'Smith', 'D', 'D','01-APR-19');
INSERT INTO PARTICIPANT (fname, lname, nationality, birth_place, dob) VALUES('Joe5', 'Smith', 'E', 'E','01-APR-19');
INSERT INTO PARTICIPANT (fname, lname, nationality, birth_place, dob) VALUES('Joe6', 'Smith', 'F', 'F','01-APR-19');
INSERT INTO PARTICIPANT (fname, lname, nationality, birth_place, dob) VALUES('Joe7', 'Smith', 'G', 'G','01-APR-19');
INSERT INTO PARTICIPANT (fname, lname, nationality, birth_place, dob) VALUES('Joe8', 'Smith', 'H', 'H','01-APR-19');
INSERT INTO PARTICIPANT (fname, lname, nationality, birth_place, dob) VALUES('Joe9', 'Smith', 'I', 'I','01-APR-19');
INSERT INTO PARTICIPANT (fname, lname, nationality, birth_place, dob) VALUES('Joe10', 'Smith', 'J', 'J','01-APR-19');
INSERT INTO PARTICIPANT (fname, lname, nationality, birth_place, dob) VALUES('Joe11', 'Smith', 'K', 'K','01-APR-19');
INSERT INTO PARTICIPANT (fname, lname, nationality, birth_place, dob) VALUES('Joe12', 'Smith', 'L', 'L','01-APR-19');
INSERT INTO PARTICIPANT (fname, lname, nationality, birth_place, dob) VALUES('Joe13', 'Smith', 'M', 'M','01-APR-19');


INSERT INTO TEAM_MEMBER VALUES (1,1);
INSERT INTO TEAM_MEMBER VALUES (1,2);
INSERT INTO TEAM_MEMBER VALUES (2,3);
INSERT INTO TEAM_MEMBER VALUES (2,4);
INSERT INTO TEAM_MEMBER VALUES (2,5);
INSERT INTO TEAM_MEMBER VALUES (2,6);
INSERT INTO TEAM_MEMBER VALUES (3,7);
INSERT INTO TEAM_MEMBER VALUES (3,8);

INSERT INTO MEDAL VALUES (1, 'Gold', 3);
INSERT INTO MEDAL VALUES (2, 'Silver', 2);
INSERT INTO MEDAL VALUES (3, 'Bronze', 1);

DELETE PARTICIPANT WHERE participant_id = 1;

INSERT INTO VENUE(olympic_id, venue_name, capacity) VALUES (1,'Venue1',3);
INSERT INTO VENUE(olympic_id, venue_name, capacity) VALUES (1,'Venue2',3);


INSERT INTO EVENT(sport_id, venue_id, gender, event_time) VALUES(1,1,'m','01-APR-19');
INSERT INTO EVENT(sport_id, venue_id, gender, event_time) VALUES(1,1,'m','01-APR-19');
INSERT INTO EVENT(sport_id, venue_id, gender, event_time) VALUES(1,1,'m','01-APR-19');
INSERT INTO EVENT(sport_id, venue_id, gender, event_time) VALUES(1,1,'m','01-APR-19');
INSERT INTO EVENT(sport_id, venue_id, gender, event_time) VALUES(1,2,'m','01-APR-19');
INSERT INTO EVENT(sport_id, venue_id, gender, event_time) VALUES(1,2,'m','01-APR-19');


INSERT INTO SCOREBOARD(olympics_id,event_id,team_id,participant_id,position,medal_id) VALUES (1,1,3,1,1,2);
INSERT INTO SCOREBOARD(olympics_id,event_id,team_id,participant_id,position,medal_id) VALUES (1,1,4,2,2,1);
INSERT INTO SCOREBOARD(olympics_id,event_id,team_id,participant_id,position) VALUES (1,1,5,3,3);
INSERT INTO SCOREBOARD(olympics_id,event_id,team_id,participant_id,position) VALUES (1,1,6,4,4);
