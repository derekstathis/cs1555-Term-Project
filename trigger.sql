--Derek Stathis
--Term Project
--Triggers


--THIS TRIGGER IS MUTATING AND I AM A
CREATE OR REPLACE TRIGGER ASSIGN_MEDAL 
    BEFORE UPDATE or INSERT ON SCOREBOARD
    FOR EACH ROW
    WHEN (new.position < 4)
    DECLARE
        newPosition number;
    BEGIN
        newPosition := :NEW.position;
        IF newPosition = 1 THEN
            :NEW.medal_id := 1;
        END IF;
        IF newPosition = 2 THEN
            :NEW.medal_id := 2;
        END IF;
        IF newPosition = 3 THEN
            :NEW.medal_id := 3;
        END IF;
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
    BEFORE UPDATE OR INSERT ON EVENT
    FOR EACH ROW
    DECLARE
        overCapacity EXCEPTION;
        cap number;
        cur number;
        id number;
    BEGIN
        SELECT COUNT(venue_id) into cur 
        FROM EVENT 
        WHERE venue_id = :new.venue_id AND event_time = :new.event_time;
        SELECT venue_id, capacity into id,cap 
        FROM VENUE 
        WHERE VENUE.venue_id = :new.venue_id;
        IF cur >= cap THEN RAISE overCapacity;
        END IF;
        
    END;
    /
