
--values need to be added to the parameters to get the queries to work correctly 
--Create User--
    insert into user_account (user_id,username,passkey,role_id) values (account_seq.nextVal,?,?,?);
    
--Drop User--
    delete from USER_RECORDS where user_id=?;
    
--Create Event--
    insert into Event (event_id,sport_id,venue_id,gender) values (event.nextVal,?,?,?);
    
--Add Event Outcome--
    insert into scoreboard (event_id,team_id,participant_id,postition) values (?,?,?,?);
    
--Create Team--
    select country_id from country where country = ?;
    select sport_id from sport where sport_name = ?;
    select olympic_id from olympics where host_city = ?;
    select user_id from user_account where username = ?;
    insert into team values (team_seq.nextval, olympic_id,team_name,country_id, sport_id, coach_id);
    
--Register Team--
    insert into event_participation values ? where event_id = ?;
    
--Add Participant
    insert into participant (participant_id,fname,lname,nationality,birth_place) values (participant.nextVal,?,?,?,?);
    
--Add Team Member--
    insert into TEAM_MEMBER values (?, ?);
    
--Drop Team Member--
    delete from participant where participant_id=?;
    
--Login--
    select role_id from user_account where username = username and passkey = password;
    update user_account set last_login = systimestamp where username = username;
    
--Display Sport--
    select dob from sport where sport_name = ? natural join event where sport.sport_id = event.sport_id;