--Derek Stathis
--Term Project
--Triggers

DROP SEQUENCE ACCOUNT_SEQ;
DROP SEQUENCE OLYMPICs_SEQ;
DROP SEQUENCE SPORT_SEQ;
DROP SEQUENCE PARTICIPANT_SEQ;
DROP SEQUENCE COUNTRY_SEQ;
DROP SEQUENCE EVENT_SEQ;
DROP SEQUENCE TEAM_SEQ;
DROP SEQUENCE VENUE_SEQ;



CREATE SEQUENCE ACCOUNT_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE OR REPLACE TRIGGER ACCOUNT_TRIG
    BEFORE INSERT ON USER_ACCOUNT
    FOR EACH ROW
    BEGIN
        :new.user_id := ACCOUNT_SEQ.nextval;
    END;
/

CREATE SEQUENCE OLYMPICS_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE OR REPLACE TRIGGER OLYMPICS_TRIG
    BEFORE INSERT ON OLYMPICS
    FOR EACH ROW
    BEGIN
        :new.olympic_id := OLYMPICS_SEQ.nextval;
    END;
/

CREATE SEQUENCE SPORT_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE OR REPLACE TRIGGER SPORT_TRIG
    BEFORE INSERT ON SPORT    
    FOR EACH ROW
    BEGIN
        :new.sport_id := SPORT_SEQ.nextval;
    END;
/

CREATE SEQUENCE PARTICIPANT_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE OR REPLACE TRIGGER PARTICIPANT_TRIG
    BEFORE INSERT ON PARTICIPANT
    FOR EACH ROW
    BEGIN
        :new.participant_id := PARTICIPANT_SEQ.nextval;
    END;
/

CREATE SEQUENCE COUNTRY_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE OR REPLACE TRIGGER COUNTRY_TRIG
    BEFORE INSERT ON COUNTRY
    FOR EACH ROW
    BEGIN
        :new.country_id := COUNTRY_SEQ.nextval;
    END;
/

CREATE SEQUENCE EVENT_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE OR REPLACE TRIGGER EVENT_TRIG
    BEFORE INSERT ON EVENT
    FOR EACH ROW
    BEGIN
        :new.event_id := EVENT_SEQ.nextval;
    END;
/

CREATE SEQUENCE TEAM_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TEAM_TRIG
    BEFORE INSERT ON TEAM
    FOR EACH ROW
    BEGIN
        :new.team_id := TEAM_SEQ.nextval;
    END;
/

CREATE SEQUENCE VENUE_SEQ
    START WITH 1
    INCREMENT BY 1;
    
CREATE OR REPLACE TRIGGER VENUE_TRIG
    BEFORE INSERT ON VENUE
    FOR EACH ROW
    BEGIN
        :new.venue_id := VENUE_SEQ.nextval;
    END;
/


CREATE OR REPLACE TRIGGER ASSIGN_MEDAL
AFTER INSERT OR UPDATE 
ON SCOREBOARD
FOR EACH ROW
BEGIN
    if :new.position = 1 then
        update SCOREBOARD
        set medal_id = 1
        where :new.olympics_id = :old.olympics_id;
    elsif :new.position = 2 then
        update SCOREBOARD
        set medal_id = 2
        where :new.olympics_id = :old.olympics_id;
    elsif :new.position = 3 then
        update SCOREBOARD
        set medal_id = 3
        where :new.olympics_id = :old.olympics_id;
    end if;
END;
/




CREATE OR REPLACE TRIGGER ATHLETE_DISMISSAL
BEFORE DELETE  
ON PARTICIPANT 
FOR EACH ROW
DECLARE
    participant integer;
    player_count integer;
    delete_team integer;
BEGIN
    --DELETE FROM TEAM_MEMBER
    --WHERE TEAM_MEMBER.participant_id = :old.participant_id;
    
    SELECT count(participant) INTO player_count
        FROM TEAM_MEMBER
        WHERE TEAM_MEMBER.participant_id = :old.participant_id;
    
    SELECT team_id INTO delete_team
        FROM TEAM_MEMBER
        WHERE TEAM_MEMBER.participant_id = :old.participant_id;
        
    IF player_count = 0 THEN
        DELETE FROM TEAM_MEMBER
        WHERE team_id = delete_team;
        DELETE FROM TEAM
        WHERE team_id = delete_team;
        
    ELSIF player_count >0 THEN
        UPDATE EVENT_PARTICIPATION
        SET status = 'n'
        WHERE EVENT_PARTICIPATION.team_id = delete_team;
    END IF;
    
END;
/


CREATE OR REPLACE TRIGGER ENFORCE_CAPACITY
BEFORE INSERT OR UPDATE ON EVENT
FOR EACH ROW
DECLARE
    event_count integer;
    event_capacity integer;
    bad_data exception;
    --PRAGMA EXCEPTION_INIT( bad_data, -20001 );
BEGIN
    SELECT count(event_id) INTO event_count
        FROM EVENT
        WHERE EVENT.venue_id = :new.venue_id;
    
    SELECT VENUE.capacity INTO event_capacity
        FROM VENUE
        WHERE VENUE.venue_id = :new.venue_id;
        
    IF event_count = event_capacity THEN
        dbms_output.put_line('BAD DATA');
    END IF;
END;
/


