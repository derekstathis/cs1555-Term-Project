--DEREK STATHIS
--TERM PROJECT
--CREATES TABLES AND CONSTRAINTS

DROP TABLE USER_ACCOUNT CASCADE CONSTRAINTS;
DROP TABLE USER_ROLE CASCADE CONSTRAINTS;
DROP TABLE OLYMPICS CASCADE CONSTRAINTS;
DROP TABLE SPORT CASCADE CONSTRAINTS;
DROP TABLE PARTICIPANT CASCADE CONSTRAINTS;
DROP TABLE COUNTRY CASCADE CONSTRAINTS;
DROP TABLE TEAM CASCADE CONSTRAINTS;
DROP TABLE TEAM_MEMBER CASCADE CONSTRAINTS;
DROP TABLE MEDAL CASCADE CONSTRAINTS;
DROP TABLE SCOREBOARD CASCADE CONSTRAINTS;
DROP TABLE VENUE CASCADE CONSTRAINTS;
DROP TABLE EVENT CASCADE CONSTRAINTS;
DROP TABLE EVENT_PARTICIPATION CASCADE CONSTRAINTS;


CREATE TABLE USER_ROLE(
role_id     integer not null,
role_name   varchar(20),
CONSTRAINT user_role_pk PRIMARY KEY(role_id)
);

CREATE TABLE USER_ACCOUNT(
user_id     integer,
username    varchar2(20),
passkey     varchar2(20),
role_id     integer,
last_login  date,
CONSTRAINT user_acc_pk PRIMARY KEY(user_id),
CONSTRAINT acc_role_fk FOREIGN KEY (role_id) REFERENCES USER_ROLE(role_id)
);

CREATE TABLE OLYMPICS(
olympic_id      integer not null,
olympic_num     varchar2(30) not null,
host_city       varchar2(30) not null,
opening_date    date,
closing_date    date,
official_website varchar2(50) not null,
CONSTRAINT olympics_pk PRIMARY KEY(olympic_id),
CONSTRAINT olympics_un UNIQUE(olympic_num)
);

CREATE TABLE SPORT(
sport_id    integer not null,
sport_name  varchar2(30) not null,
description varchar2(80),
dob         date,
team_size   integer not null,
CONSTRAINT sport_pk PRIMARY KEY(sport_id)
);

CREATE TABLE PARTICIPANT(
participant_id  integer not null,
fname           varchar2(30) not null,
lname           varchar2(30) not null,
nationality     varchar2(20) not null,
birth_place     varchar2(40) not null,
dob             date,
CONSTRAINT participant_pk PRIMARY KEY(participant_id)
);

CREATE TABLE COUNTRY(
country_id  integer not null,
country     varchar2(20),
country_code varchar2(3),
CONSTRAINT country_pk PRIMARY KEY(country_id)
);

CREATE TABLE TEAM(
team_id     integer not null,
olympic_id  integer not null,
team_name   varchar2(50),
country_id  integer not null,
sport_id    integer not null,
coach_id    integer,
CONSTRAINT team_pk PRIMARY KEY(team_id),
CONSTRAINT team_country_fk FOREIGN KEY(country_id) REFERENCES COUNTRY(country_id),
CONSTRAINT team_sport_fk FOREIGN KEY(sport_id) REFERENCES SPORT(sport_id),
CONSTRAINT team_olympics_fk FOREIGN KEY(olympic_id) REFERENCES OLYMPICS(olympic_id),
--CONSTRAINT team_participant_fk FOREIGN KEY(coach_id) REFERENCES PARTICIPANT(participant_id),
CONSTRAINT HAS_COACH CHECK(coach_id is not null)
);

CREATE TABLE TEAM_MEMBER(
team_id         integer,
participant_id  integer,
CONSTRAINT team_member_pk PRIMARY KEY(team_id,participant_id),
CONSTRAINT members_team_fk FOREIGN KEY(team_id) REFERENCES TEAM(team_id),
CONSTRAINT members_participant_fk FOREIGN KEY(participant_id) REFERENCES PARTICIPANT(participant_id)
);

CREATE TABLE MEDAL(
medal_id        integer not null,
medal_title     varchar2(6),
points          integer not null,
CONSTRAINT medal_pk PRIMARY KEY(medal_id)
);

CREATE TABLE VENUE(
venue_id        integer not null,
olympic_id     integer not null,
venue_name      varchar2(30),
capacity        integer not null,
CONSTRAINT venue_pk PRIMARY KEY(venue_id),
CONSTRAINT venue_olympics_fk FOREIGN KEY(olympic_id) REFERENCES OLYMPICS(olympic_id)
);

CREATE TABLE EVENT(
event_id        integer not null,
sport_id        integer not null,
venue_id        integer not null,
gender          char,
event_time      date not null,
CONSTRAINT event_pk PRIMARY KEY(event_id),
CONSTRAINT event_sport_fk FOREIGN KEY(sport_id) REFERENCES SPORT(sport_id),
CONSTRAINT event_venue_fk FOREIGN KEY(venue_id) REFERENCES VENUE(venue_id)
);

CREATE TABLE EVENT_PARTICIPATION(
event_id        integer not null,
team_id         integer,
status          char,
CONSTRAINT participation_pk PRIMARY KEY(event_id, status),
CONSTRAINT participation_team_fk FOREIGN KEY(team_id) REFERENCES TEAM(team_id),
CONSTRAINT participation_event_fk FOREIGN KEY(event_id) REFERENCES EVENT(event_id)
);

CREATE TABLE SCOREBOARD(
olympics_id     integer,
event_id        integer not null,
team_id         integer not null,
participant_id  integer,
position        integer not null,
medal_id        integer,
CONSTRAINT scoreboard_pk PRIMARY KEY(event_id, medal_id, team_id),
CONSTRAINT scoreboard_olympics_fk FOREIGN KEY(olympics_id) REFERENCES OLYMPICS(olympic_id),
CONSTRAINT scoreboard_participant_fk FOREIGN KEY(participant_id) REFERENCES PARTICIPANT(participant_id),
CONSTRAINT scoreboard_event_fk FOREIGN KEY(event_id) REFERENCES EVENT(event_id),
CONSTRAINT scoreboard_team_fk FOREIGN KEY(team_id) REFERENCES TEAM(team_id),
CONSTRAINT scoreboard_medal_fk FOREIGN KEY(medal_id) REFERENCES MEDAL(medal_id)
);

COMMIT;








