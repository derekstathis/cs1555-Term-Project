import java.sql.*;
import java.util.Scanner;

public class Olympic 
{
    private static final String username = "dgs32";
    private static final String password = "4191109";
    private static final String url = "jdbc:oracle:thin:@class3.cs.pitt.edu:1521:dbclass";
    private static Connection connection;

    public static void main(String args[]) throws SQLException 
    {
    	
        Connection connection = null;
        try 
        {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(true);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            
            if(connection != null) System.out.println("Connection good");
            
            int choice = showChoices();
            System.out.println(choice);
            
            while(choice < 0 || choice > 16)
            {
            	System.out.println("Enter a valid choice");
            	choice = showChoices();
            }
            
            while(choice >= 0 && choice < 17)
            {
            	int a =0;
            	String c = "da";
            	Scanner s = new Scanner(System.in);
            	
            	switch(choice)
            	{
            		case 0:
            			exitSystem();
            			break;
            		case 1:
            			System.out.println("Enter your username");
            			String username = s.nextLine();
            			
            			System.out.println("Enter your password");
            			String password = s.nextLine();
            			
            			System.out.println("Enter your role Id number");
            			int role_id = s.nextInt();
            			
            			createUser(username, password, role_id, connection);
            			break;
            		case 2:
            			System.out.println("Enter the user ID number to drop");
            			int id = s.nextInt();
            			
            			dropUser(id, connection);
            			break;
            		case 3:
            			System.out.println("Enter the sport ID");
            			int sport = s.nextInt();
            			
            			System.out.println("Enter the venue ID");
            			int venue = s.nextInt();
            			
            			System.out.println("Enter the date/time of event");
            			String d = s.nextLine();
            			
            			System.out.println("Enter 'm' or 'f' for the gender of the event");
            			String gender = s.nextLine();
            			
            			createEvent(sport, venue, d, gender, connection);
            			break;
            		case 4:
            			System.out.println("Enter the event");
            			String game = s.nextLine();
            			
            			System.out.println("Enter the team ID");
            			int tID = s.nextInt();
            			
            			System.out.println("Enter the event ID");
            			int eid = s.nextInt();
            			
            			System.out.println("Enter the participant ID");
            			int pID = s.nextInt();
            			
            			System.out.println("Enter the position they came in as a number");
            			int pos = s.nextInt();
            			
            			addEventOutcome(game, tID, eid, pID, pos, connection);
            			break;
            		case 5:
            			System.out.println("Enter the olympic city");
            			String city  = s.nextLine();
            			
            			System.out.println("Enter the year of this olympics");
            			int year = s.nextInt();
            			
            			System.out.println("Enter the sport ID");
            			int sid = s.nextInt();
            			
            			System.out.println("Enter the country ID");
            			int cid = s.nextInt();
            			
            			System.out.println("Enter the team name");
            			String name = s.nextLine();
            			
            			createTeam(city, year, sid, cid, name, connection);
            			break;
            		case 6:
            			System.out.println("Enter the team ID");
            			int t_id = s.nextInt();
            			
            			System.out.println("Enter the event ID");
            			int e_id = s.nextInt();
            			
            			registerTeam(t_id, e_id, connection);
            			break;
            		case 7:
            			System.out.println("Enter your first name");
            			String f = s.nextLine();
            			
            			System.out.println("Enter your last name");
            			String l = s.nextLine();
            			
            			System.out.println("Enter your nationality");
            			String n = s.nextLine();
            			
            			System.out.println("Enter your birthplace");
            			String birth = s.nextLine();
            			
            			System.out.println("Enter your date of birth");
            			String dob = s.nextLine();
            			
            			addParticipant(f, l, n, birth, dob, connection);
            			break;
            		case 8:
            			System.out.println("Enter the team ID");
            			int tid = s.nextInt();
            			
            			System.out.println("Enter the participant ID");
            			int pid = s.nextInt();
            			
            			addTeamMember(tid, pid, connection);
            			break;
            		case 9:
            			System.out.println("Enter the team ID");
            			int teamid = s.nextInt();
            			
            			System.out.println("Enter the participant ID");
            			int parid = s.nextInt();
            			
            			dropTeamMember(teamid, parid, connection);
            			break;
            		case 10:
            			System.out.println("Enter your username");
            			String uname = s.nextLine();
            			
            			System.out.println("Enter your password");
            			String pword = s.nextLine();
            			
            			login(uname, pword, connection);
            			break;
            		case 11:
            			System.out.println("Enter the sport name");
            			String sport_name = s.nextLine();
            			
            			displaySport(sport_name, connection);
            			break;
            		case 12:
            			System.out.println("Enter the city of the olympics");
            			String city_name = s.nextLine();
            			
            			System.out.println("Enter the year of the olympics");
            			int year_oly = s.nextInt();
            			
            			System.out.println("Enter the event ID");
            			int event_i = s.nextInt();
            			
            			displayEvent(city_name, year_oly, event_i, connection);
            			break;
            		case 13:
            			countryRanking(a);
            			break;
            		case 14:
            			topkAthletes(a, a);
            			break;
            		case 15:
            			connectedAthletes(a, a, a);
            			break;
            		case 16:
            			choice = logout();
            			break;
            	}
            	choice = showChoices();
            }
        }   
        catch (SQLException e) 
        {
            System.out.println(
                    "Error connecting to database. Printing stack trace: ");
            e.printStackTrace();
        }
		
    }
    
    public static int showChoices()
    {
    	Scanner s = new Scanner(System.in);
    	
    	System.out.println("Welcome to the olympics database!");
    	System.out.println("1. Create a user.");
    	System.out.println("2. Drop a user.");
    	System.out.println("3. Create an event.");
    	System.out.println("4. Add event outcome.");
    	System.out.println("5. Create a team.");
    	System.out.println("6. Register a team.");
    	System.out.println("7. Add a participant.");
    	System.out.println("8. Add a team member.");
    	System.out.println("9. Drop a team member.");
    	System.out.println("10. Login.");
    	System.out.println("11. Display a sport.");
    	System.out.println("12. Display an event.");
    	System.out.println("13. Display country ranking.");
    	System.out.println("14. Display top athletes.");
    	System.out.println("15. Find connected athletes.");
    	System.out.println("16. Logout.");
    	System.out.println("0. Exit.");
    	
    	
    	int choice  = s.nextInt();
    	return choice;
    	
    }
    
    
    public static void createUser(String username, String passkey, int role_id, Connection connection)
    {
    	PreparedStatement insertStatement = null;
    	Statement stat = null;
    	ResultSet rs = null;
    	//Date date = new Date(0);
    	
    	try
    	{
    		stat = connection.createStatement();
    		String query = "insert into user_account (user_id,username,passkey,role_id) values (account_seq.nextVal,?,?,?)";

    			
    		insertStatement = connection.prepareStatement(query);
    		insertStatement.setString(1, username);
    		insertStatement.setString(2, passkey);
    		insertStatement.setInt(3, role_id);
    		//insertStatement.setDate(5, date);
    		rs = insertStatement.executeQuery();
    		
    		stat.close();
    		insertStatement.close();
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
            
        }
		finally 
		{
			try 
			{
                if (rs != null) rs.close();
				if (stat != null) stat.close();
				if (insertStatement != null) insertStatement.close();
            } 
			catch (SQLException e) 
			{
                System.out.println("Cannot close Statement. Machine error: "+e.toString());
            }
		}
    }
    
    public static void dropUser(int user_id, Connection connection)
    {
    	PreparedStatement deleteStatement = null;
    	Statement stat = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "delete from USER_RECORDS where user_id=?";
    		stat = connection.createStatement();
    		
    		deleteStatement = connection.prepareStatement(query);
    		deleteStatement.setInt(1, user_id);
    		rs = stat.executeQuery(query);
    		
    		stat.close();
    		deleteStatement.close();
    		
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
            
        }
		finally 
		{
			try 
			{
                if (rs != null) rs.close();
				if (stat != null) stat.close();
				if (deleteStatement != null) deleteStatement.close();
            } 
			catch (SQLException e) 
			{
                System.out.println("Cannot close Statement. Machine error: "+e.toString());
            }
		}
    }
    
    public static void createEvent(int sport_id, int venue_id, String date, String gender, Connection connection)
    {
    	PreparedStatement insertStatement = null;
    	Statement stat = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "insert into Event (event_id,sport_id,venue_id,gender) values (event.nextVal,?,?,?)";
    		stat = connection.createStatement();

    		
    		
    		insertStatement = connection.prepareStatement(query);
    		insertStatement.setInt(1, sport_id);
    		insertStatement.setInt(2, venue_id);
    		insertStatement.setString(3, gender);
    		//insertStatement.setString(5, date);
    		
    		rs = stat.executeQuery(query);
    			
    		stat.close();
    		insertStatement.close();
    		
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
           
        }
		finally 
		{
			try 
			{
                if (rs != null) rs.close();
				if (stat != null) stat.close();
				if (insertStatement != null) insertStatement.close();
            } 
			catch (SQLException e) 
			{
                System.out.println("Cannot close Statement. Machine error: "+e.toString());
            }
		}
    }
    
    public static void addEventOutcome(String game, int team_id, int event_id, int participant_id, int position, Connection connection)
    {
    	PreparedStatement insertStatement = null;
    	Statement stat = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "insert into scoreboard (event_id,team_id,participant_id,postition) values (?,?,?,?)";
    		stat = connection.createStatement();
    		
    		insertStatement = connection.prepareStatement(query);
    		insertStatement.setInt(1, event_id);
    		insertStatement.setInt(2, team_id);
    		insertStatement.setInt(3, participant_id);
    		insertStatement.setInt(4, position);
    		
    		rs = stat.executeQuery(query);
    		stat.close();
    		insertStatement.close();
    		
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
            
        }
		finally 
		{
			try 
			{
                if (rs != null) rs.close();
				if (stat != null) stat.close();
				if (insertStatement != null) insertStatement.close();
            } 
			catch (SQLException e) 
			{
                System.out.println("Cannot close Statement. Machine error: "+e.toString());
            }
		}
    }
    
    public static void createTeam(String city, int year, int sport_id, int country_id, String team_name, Connection connection)
    {
    	PreparedStatement insertStatement = null;
    	Statement stat = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "insert into team (team_id,team_name,country_id,sport_id) values (team.nextVal,?,?,?,team.nextVal)";
    		stat = connection.createStatement();

    		
    		insertStatement = connection.prepareStatement(query);
    		insertStatement.setString(1, team_name);
    		insertStatement.setInt(2, country_id);
    		insertStatement.setInt(3, sport_id);
    		
    		rs = stat.executeQuery(query);
    		stat.close();
    		insertStatement.close();
    		
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
            
        }
		finally 
		{
			try 
			{
                if (rs != null) rs.close();
				if (stat != null) stat.close();
				if (insertStatement != null) insertStatement.close();
            } 
			catch (SQLException e) 
			{
                System.out.println("Cannot close Statement. Machine error: "+e.toString());
            }
		}
    }
    
    public static void registerTeam(int team_id, int event_id, Connection connection)
    {
    	PreparedStatement insertStatement = null;
    	Statement stat = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "insert into event_participation values (?) where event_id = ?";
    		stat = connection.createStatement();


    		insertStatement = connection.prepareStatement(query);
    		insertStatement.setInt(1,team_id);
    		insertStatement.setInt(2, event_id);
    		
    		rs = stat.executeQuery(query);
    		stat.close();
    		insertStatement.close();
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
            
        }
		finally 
		{
			try 
			{
                if (rs != null) rs.close();
				if (stat != null) stat.close();
				if (insertStatement != null) insertStatement.close();
            } 
			catch (SQLException e) 
			{
                System.out.println("Cannot close Statement. Machine error: "+e.toString());
            }
		}
    	
    }
    
    public static void addParticipant(String fname, String lname, String nationality, String birthplace, String dob, Connection connection)
    {
    	PreparedStatement insertStatement = null;
    	Statement stat = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "insert into participant (participant_id,fname,lname,nationality,birth_place) values (participant.nextVal,?,?,?,?)";
    		stat = connection.createStatement();


    		
    		insertStatement = connection.prepareStatement(query);
    		insertStatement.setString(1, fname);
    		insertStatement.setString(2, lname);
    		insertStatement.setString(3, nationality);
    		insertStatement.setString(4, birthplace);
    		//insertStatement.setString(6, dob);
    		
    		rs = stat.executeQuery(query);
    		stat.close();
    		insertStatement.close();
    		
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
            
        }
		finally 
		{
			try 
			{
                if (rs != null) rs.close();
				if (stat != null) stat.close();
				if (insertStatement != null) insertStatement.close();
            } 
			catch (SQLException e) 
			{
                System.out.println("Cannot close Statement. Machine error: "+e.toString());
            }
		}
    }
    
    public static void addTeamMember(int team_id, int participant_id, Connection connection)
    {
    	PreparedStatement insertStatement = null;
    	Statement stat = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "insert into TEAM_MEMBER values (?, ?)";
    		stat = connection.createStatement();
    		
    		insertStatement = connection.prepareStatement(query);
        	insertStatement.setInt(1, team_id);
        	insertStatement.setInt(2, participant_id);
        	
        	rs = stat.executeQuery(query);
        	stat.close();
    		insertStatement.close();
    		
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
            
        }
		finally 
		{
			try 
			{
                if (rs != null) rs.close();
				if (stat != null) stat.close();
				if (insertStatement != null) insertStatement.close();
            } 
			catch (SQLException e) 
			{
                System.out.println("Cannot close Statement. Machine error: "+e.toString());
            }
		}
    }
    
    public static void dropTeamMember(int team_id, int participant_id, Connection connection)
    {
    	PreparedStatement deleteStatement = null;
    	Statement stat = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "delete from TEAM_MEMBER where participant_id=? and team_id=?";
    		stat = connection.createStatement();
    		
    		deleteStatement = connection.prepareStatement(query);
    		deleteStatement.setInt(1, team_id);
    		deleteStatement.setInt(2, participant_id);
    		
    		rs = stat.executeQuery(query);
    		stat.close();
    		deleteStatement.close();
    		
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
            
        }
		finally 
		{
			try 
			{
                if (rs != null) rs.close();
				if (stat != null) stat.close();
				if (deleteStatement != null) deleteStatement.close();
            } 
			catch (SQLException e) 
			{
                System.out.println("Cannot close Statement. Machine error: "+e.toString());
            }
		} 
    }
    
    public static void login(String username, String password, Connection connection)
    {
    	PreparedStatement editStatement = null;
    	Statement stat = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "select role_id from user_account"
    				+ " where username = ? and password = ? "
    				+ "natural join user_role";
    		stat = connection.createStatement();

    		
    		editStatement = connection.prepareStatement(query);
    		editStatement.setString(1, username);
    		editStatement.setString(2, password);
    		
    		rs = stat.executeQuery(query);
    		stat.close();
    		editStatement.close();
    		
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
            
        }
		finally 
		{
			try 
			{
                if (rs != null) rs.close();
				if (stat != null) stat.close();
				if (editStatement != null) editStatement.close();
            } 
			catch (SQLException e) 
			{
                System.out.println("Cannot close Statement. Machine error: "+e.toString());
            }
		}
    }
    
    public static void displaySport(String sport_name, Connection connection)
    {
    	PreparedStatement editStatement = null;
    	Statement stat = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "select dob from sport where sport_name = ?"
    				+ " natural join event where sport.sport_id = event.sport_id";
    		stat = connection.createStatement();

    		editStatement = connection.prepareStatement(query);
    		editStatement.setString(1, sport_name);
    		
    		rs = stat.executeQuery(query);
    		stat.close();
    		editStatement.close();
    	
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
            
        }
		finally 
		{
			try 
			{
                if (rs != null) rs.close();
				if (stat != null) stat.close();
				if (editStatement != null) editStatement.close();
            } 
			catch (SQLException e) 
			{
                System.out.println("Cannot close Statement. Machine error: "+e.toString());
            }
		}
    }
    
    public static void displayEvent(String city, int year, int event_id, Connection connection)
    {
    	PreparedStatement editStatement = null;
    	Statement stat = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "Select sport_name  ";
    		stat = connection.createStatement();
    		
    		
    		editStatement = connection.prepareStatement(query);
    		//editStatement.setString(1, sport_name);
    		//got confused here with how to access the name of the event 
    		rs = stat.executeQuery(query);
    		stat.close();
    		editStatement.close();
    		
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
            
        }
		finally 
		{
			try 
			{
                if (rs != null) rs.close();
				if (stat != null) stat.close();
				if (editStatement != null) editStatement.close();
            } 
			catch (SQLException e) 
			{
                System.out.println("Cannot close Statement. Machine error: "+e.toString());
            }
		}
    }
    
    public static void countryRanking(int olympics_id)
    {
    	//TODO country ranking
    }
    
    public static void topkAthletes(int olympics_id, int k)
    {
    	//TODO topkAthletes
    }
    
    public static void connectedAthletes(int participant_id, int olympics_id, int n)
    {
    	//TODO connected Athletes
    }
    
    public static int logout()
    {
    	System.out.println("This user has been logged out");
		int choice = showChoices();
    	
		return choice;
    }
    
    public static void exitSystem()
    {
    	System.out.println("\nGoodbye.\n");
    	System.exit(0);
    }
    
    
    
    
    
    
    
    
    
    
   
}