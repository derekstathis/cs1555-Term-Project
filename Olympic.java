import java.sql.*;
import java.util.Scanner;

//Derek Stathis
//DGS32
//Phase 2

public class Olympic 
{
    private static final String username = "dgs32";
    private static final String password = "4191109";
    private static final String url = "jdbc:oracle:thin:@class3.cs.pitt.edu:1521:dbclass";
    private static Connection databaseConnection;
    
    private static String userLogin;
    private static int roleCode;
    private static boolean access = false;
    
    
    public Olympic()
    {
    	Connection connection;
        try 
        {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(true);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection = DriverManager.getConnection("jdbc:oracle:thin:@class3.cs.pitt.edu:1521:dbclass", username, password);
            databaseConnection = connection;
    	}   
    	catch (SQLException e) 
    	{
    		System.out.println("Error connecting to database. Printing stack trace: ");
    		e.printStackTrace();
    	}
    }

    public static void main(String args[]) throws SQLException 
    {        
    	Olympic olympic = new Olympic();
            int choice = showChoices();
            System.out.println(choice);
            
            System.out.println("Login to get access to more options.");
            //createRole();
            /*
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
            			
            			createUser(1, username, password, role_id);
            			break;
            		case 2:
            			System.out.println("Enter the user ID number to drop");
            			int id = s.nextInt();
            			
            			dropUser(id);
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
            			
            			createEvent(sport, venue, d, gender);
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
            			
            			addEventOutcome(game, tID, eid, pID, pos, 1);
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
            			
            			createTeam(city, year, sid, cid, name);
            			break;
            		case 6:
            			System.out.println("Enter the team ID");
            			int t_id = s.nextInt();
            			
            			System.out.println("Enter the event ID");
            			int e_id = s.nextInt();
            			
            			registerTeam(t_id, e_id, "e");
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
            			
            			addParticipant(1, f, l, n, birth, dob);
            			break;
            		case 8:
            			System.out.println("Enter the team ID");
            			int tid = s.nextInt();
            			
            			System.out.println("Enter the participant ID");
            			int pid = s.nextInt();
            			
            			addTeamMember(tid, pid);
            			break;
            		case 9:
            			System.out.println("Enter the team ID");
            			int teamid = s.nextInt();
            			
            			System.out.println("Enter the participant ID");
            			int parid = s.nextInt();
            			
            			dropTeamMember(parid);
            			break;
            		case 10:
            			System.out.println("Enter your username");
            			String uname = s.nextLine();
            			
            			System.out.println("Enter your password");
            			String pword = s.nextLine();
            			
            			login(uname, pword);
            			break;
            		case 11:
            			System.out.println("Enter the sport name");
            			String sport_name = s.nextLine();
            			
            			displaySport(sport_name);
            			break;
            		case 12:
            			System.out.println("Enter the city of the olympics");
            			String city_name = s.nextLine();
            			
            			System.out.println("Enter the year of the olympics");
            			int year_oly = s.nextInt();
            			
            			System.out.println("Enter the event ID");
            			int event_i = s.nextInt();
            			
            			displayEvent(city_name, year_oly, event_i);
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
		*/
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
    //SOME OF THESE ARE SOLELY USED IN DRIVER.JAVA AS INPUT FUNCTIONS
    
    public static void createOlympics(int olympic_id, String olympic_num, String city, String website) throws SQLException
    {
    	try
    	{
    		PreparedStatement ps = databaseConnection.prepareStatement("insert into olympics values(?,?,?,NULL,NULL,?)");
        	ps.setInt(1, olympic_id);
    		ps.setString(2, olympic_num);
    		ps.setString(3, city);
    		ps.setString(4, website);
    		ResultSet rs = ps.executeQuery();
    		
    		ps.close();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	
    	
    }
    
    public static void createCountry(int country_id, String country_name, String country_code)
    {
    	try
    	{
    		PreparedStatement ps = databaseConnection.prepareStatement("insert into country values (?,?,?)");
    		ps.setInt(1, country_id);
    		ps.setString(2, country_name);
    		ps.setString(3, country_code);
    		ResultSet rs = ps.executeQuery();
    		
    		ps.close();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void createVenue(int venue_id, int olympic_id,String venue_name, int capacity)
    {
    	try
    	{
    		PreparedStatement ps = databaseConnection.prepareStatement("insert into venue values (?,?,?,?)");
        	ps.setInt(1, venue_id);
        	ps.setInt(2, olympic_id);
        	ps.setString(3, venue_name);
        	ps.setInt(4, capacity);
        	
        	ResultSet rs = ps.executeQuery();
        	ps.close();

    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void createSport(int sport_id, String sport_name, String description, String date, int team_size)
    {
    	try
    	{
    		PreparedStatement ps = databaseConnection.prepareStatement("insert into sport (sport_id,sport_name, description, dob"
    				+ ", team_size) values(?,?,?,?,?)");
    		ps.setInt(1, sport_id);
    		ps.setString(2, sport_name);
    		ps.setString(3, description);
    		ps.setString(4, date);
    		ps.setInt(5, team_size);
    		
    		ResultSet rs = ps.executeQuery();
    		ps.close();

    		
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void createMedal(int medal_id, String medal_title, int points)
    {
    	try
    	{
    		PreparedStatement ps = databaseConnection.prepareStatement("insert into medal values (?,?,?)");
        	ps.setInt(1, medal_id);
        	ps.setString(2, medal_title);
        	ps.setInt(3, points);
        	ResultSet rs = ps.executeQuery();
        	ps.close();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void createRole(int role_id, String role_name) throws SQLException
    {	
    	PreparedStatement insertStatement = databaseConnection.prepareStatement("insert into user_role values (?,?)");
    	insertStatement.setInt(1, role_id);
    	insertStatement.setString(2, role_name);

    	ResultSet rs = insertStatement.executeQuery();
    	
    	insertStatement.close();
    	

    }
    
    public static void createUser(int user_id,String username, String passkey, int role_id)
    {
    	
    	PreparedStatement insertStatement = null;
    	ResultSet rs = null;
    	
    	try
    	{

    		String query = "insert into user_account (user_id,username,passkey,role_id) values (?,?,?,?)";

    		insertStatement = databaseConnection.prepareStatement(query);
    		insertStatement.setInt(1, user_id);
    		insertStatement.setString(2, username);
    		insertStatement.setString(3, passkey);
    		insertStatement.setInt(4, role_id);

    		rs = insertStatement.executeQuery();
    		
    		insertStatement.close();
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
            
        }
    }
    
    public static void dropUser(int user_id)
    {
    	PreparedStatement deleteStatement = null;
    	Statement stat = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "delete from user_account where user_id=?";
    		stat = databaseConnection.createStatement();
    		
    		deleteStatement = databaseConnection.prepareStatement(query);
    		deleteStatement.setInt(1, user_id);
    		rs = deleteStatement.executeQuery();
    		
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
    
    public static void createEvent(int event_id, int sport_id, int venue_id, String gender, String date)
    {
    	PreparedStatement insertStatement = null;
    	Statement stat = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "insert into Event values (?,?,?,?,?)";
    		stat = databaseConnection.createStatement();

    		
    		
    		insertStatement = databaseConnection.prepareStatement(query);
    		insertStatement.setInt(1, event_id);
    		insertStatement.setInt(2, sport_id);
    		insertStatement.setInt(3, venue_id);
    		insertStatement.setString(4, gender);
    		insertStatement.setString(5, date);
    		
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
    
    public static void addEventOutcome(int olympic_id, int team_id, int event_id, int participant_id, int position, int medal_id)
    {
    	PreparedStatement insertStatement = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "insert into scoreboard values (?,?,?,?,?,NULL)";
    		
    		insertStatement = databaseConnection.prepareStatement(query);
    		insertStatement.setInt(1, olympic_id);
    		insertStatement.setInt(2, event_id);
    		insertStatement.setInt(3, team_id);
    		insertStatement.setInt(4, participant_id);
    		insertStatement.setInt(5, position);
    		
    		rs = insertStatement.executeQuery();
    		insertStatement.close();
    		
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
            
        }
    }
    
    public static void createTeam(int team_id,int olympic_id,String team_name, int country_id, int sport_id, int coach_id)
    {
    	try
    	{
    		PreparedStatement ps = databaseConnection.prepareStatement("insert into team values (?,?,?,?,?,?)");
    		ps.setInt(1, team_id);
    		ps.setInt(2, olympic_id);
    		ps.setString(3, team_name);
    		ps.setInt(4, country_id);
    		ps.setInt(5, sport_id);
    		ps.setInt(6, coach_id);
    		
    		ResultSet rs = ps.executeQuery();
    		ps.close();
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
            
        }
    }
    
    public static void registerTeam(int team_id, int event_id, String status)
    {
    	PreparedStatement insertStatement = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "insert into event_participation (event_id,team_id, status) values (?,?,?)";

    		insertStatement = databaseConnection.prepareStatement(query);
    		insertStatement.setInt(1,event_id);
    		insertStatement.setInt(2, team_id);
    		insertStatement.setString(3, status);
    		
    		rs = insertStatement.executeQuery();
    		insertStatement.close();
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
            
    	}
    	
    }
    
    public static void addParticipant(int participant_id,String fname, String lname, String nationality, String birthplace)
    {

    	PreparedStatement insertStatement = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "insert into participant (participant_id,fname,lname,nationality,birth_place) values (?,?,?,?,?)";

    		insertStatement = databaseConnection.prepareStatement(query);
    		insertStatement.setInt(1, participant_id);
    		insertStatement.setString(2, fname);
    		insertStatement.setString(3, lname);
    		insertStatement.setString(4, nationality);
    		insertStatement.setString(5, birthplace);
    		
    		rs = insertStatement.executeQuery();
    		insertStatement.close();
    		
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
            
        }
    }
    
    public static void addTeamMember(int team_id, int participant_id)
    {
    	PreparedStatement insertStatement = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "insert into TEAM_MEMBER values (?, ?)";
    		
    		insertStatement = databaseConnection.prepareStatement(query);
        	insertStatement.setInt(1, team_id);
        	insertStatement.setInt(2, participant_id);
        	
        	rs = insertStatement.executeQuery();
    		insertStatement.close();
    		
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
            
        }

    }
    
    public static void dropTeamMember(int participant_id)
    {
    	PreparedStatement deleteStatement = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "delete from participant where participant_id=?";
    		
    		deleteStatement = databaseConnection.prepareStatement(query);
    		deleteStatement.setInt(1, participant_id);
    		
    		rs = deleteStatement.executeQuery();
    		deleteStatement.close();
    		
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
            
        }
    }
    
    public static boolean login(String username, String password)
    {
    	Statement stat;

		try{
			stat = databaseConnection.createStatement();
			ResultSet rs;
			String query = "select role_id from user_account where username = '" + username + "' and passkey = '" + password + "'";
			
			rs = stat.executeQuery(query);
			
			rs.next();
			roleCode = (int)rs.getLong(1);

			stat = databaseConnection.createStatement();
			
			query = "update user_account set last_login = systimestamp where username = '" + username + "'";
			rs = stat.executeQuery(query);

			userLogin = username;

		}catch (Exception e){
			 System.out.println(
                    "Error connecting to database. Printing stack trace: ");
            //e.printStackTrace();
		}
		
		if (roleCode == 0){
			System.out.println("Incorrect password or username.");
			return false;
		}else{
			System.out.println("Login successful!");
			access = true;
			return true;
		}
    }
    
    public static void displaySport(String sport_name)
    {
    	PreparedStatement editStatement = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "select dob from sport where sport_name = ?"
    				+ " natural join event where sport.sport_id = event.sport_id";

    		editStatement = databaseConnection.prepareStatement(query);
    		editStatement.setString(1, sport_name);
    		
    		rs = editStatement.executeQuery();
    		editStatement.close();
    	
    	}
    	catch (SQLException e) 
    	{
            e.printStackTrace();
            
        }
    }
    
    public static void displayEvent(String city, int year, int event_id)
    {
    	PreparedStatement editStatement = null;
    	Statement stat = null;
    	ResultSet rs = null;
    	
    	try
    	{
    		String query = "Select sport_name  ";
    		stat = databaseConnection.createStatement();
    		
    		
    		editStatement = databaseConnection.prepareStatement(query);
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