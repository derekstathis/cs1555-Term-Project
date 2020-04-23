import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//Derek Stathis
//DGS32
//Phase 3


public class Driver extends Olympic{
	private static Connection databaseConnection;
    private static final String url = "jdbc:oracle:thin:@class3.cs.pitt.edu:1521:dbclass";
	
	public static void main(String[] args)
	{
		Connection connection;
		String username = "dgs32";
		String password = "4191109";
		
		try 
		{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(true);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection = DriverManager.getConnection("jdbc:oracle:thin:@class3.cs.pitt.edu:1521:dbclass", username, password);
            databaseConnection = connection;
    	   
			
			Driver d = new Driver();
			d.run();
		}
		catch (SQLException e)
		{
			System.out.println(e.toString());
		}
	}
	
	
	public void Driver()
	{
		
	}
	
	public void run() throws SQLException
	{
		System.out.println(">>Creating User Role...");	//USER ROLE
		super.createRole(1, "USER");
		printAll("user_role");
		System.out.println(">>User Role Created!");
		
		
		System.out.println(); //spacing
		
		System.out.println(">>Creating User...");		//ADD USER
		super.createUser(1, "derek", "123", 1);
		super.createUser(2, "stan", "123", 1);
		printAll("User_account");
		System.out.println(">>User Created!");
		
		System.out.println(); //spacing
		
		System.out.println(">>Dropping User...");		//DROP USER
		super.dropUser(1);
		printAll("User_account");
		System.out.println(">>User Dropped!");
		
		System.out.println(); //spacing
		
		System.out.println(">>Creating Olympics...");	//OLYMPICS
		super.createOlympics(1, "I","Beijing","www.Beijing.com");
		super.createOlympics(2, "II","Longon","www.London.com");
		super.createOlympics(3, "III","Athens","www.Athens.com");
		super.createOlympics(4, "IV","Rio","www.Rio.com");
		System.out.println(">>Olympics Created!");
		
		System.out.println(); //spacing
		
		System.out.println(">>Creating Sports...");		//SPORTS
		super.createSport(1,"Baseball","The sport of baseball","01-APR-19",25);
		super.createSport(2,"Basketall","The sport of basketball","01-APR-19",10);
		super.createSport(3,"Soccer","The sport of Soccer","01-APR-19",39);
		super.createSport(4,"Wrestling","The sport of wrestling","01-APR-19",2);
		super.createSport(5,"Boxing","The sport of boxing","01-APR-19",2);
		System.out.println(">>Sports Created!");
		
		System.out.println(); //spacing
		
		System.out.println(">>Creating Countries...");	//COUNTRY
		super.createCountry(1,"America","USA");
		super.createCountry(2,"China","CNA");
		super.createCountry(3,"Germany","GER");
		System.out.println(">>Countries Created!");
		
		System.out.println(); //spacing
		
		System.out.println(">>Creating Team...");		//TEAM
		super.createTeam(1, 1, "USA Baseball", 1, 1,1);
		super.createTeam(2, 1, "CNA Baseball", 2, 1,2);
		super.createTeam(3, 1, "GER Soccer", 3, 3,3);
		super.createTeam(4, 1, "USA Soccer", 1, 3,4);
		
		printAll("Team");
		System.out.println(">>Team Created!");
		
		System.out.println(); //spacing
		
		System.out.println(">>Adding Participant...");	//ADD PARTICIPANT
		super.addParticipant(1,"test1", "asdf", "America", "Pittsburgh");
		super.addParticipant(2,"test2", "asdf", "America", "Pittsburgh");
		super.addParticipant(3,"test3", "adsf", "America", "Pittsburgh");
		super.addParticipant(4,"test4", "adsf", "America", "Pittsburgh");
		super.addParticipant(5,"test5", "asdf", "America", "Pittsburgh");
		super.addParticipant(6,"test6", "asdf", "America", "Pittsburgh");
		printAll("participant");
		System.out.println(">>Participant Created!");
		
		System.out.println(); //spacing
		
		System.out.println(">>Adding Team Member...");	//ADD TEAM MEMBER
		super.addTeamMember(1, 1);
		super.addTeamMember(1, 2);
		super.addTeamMember(2, 3);
		super.addTeamMember(2, 4);
		super.addTeamMember(3, 5);
		super.addTeamMember(3, 6);
		printAll("team_member");
		System.out.println(">>Team Member Added!");
		
		System.out.println(); //spacing
		
		System.out.println(">>Creating Medals...");		//MEDAL
		super.createMedal(1, "Gold", 3);
		super.createMedal(2, "Silver", 2);
		super.createMedal(3, "Bronze", 1);
		printAll("medal");
		System.out.println(">>Medals Created!");
		
		System.out.println(); //spacing
		
		System.out.println(">>Creating Venue...");		//VENUE
		super.createVenue(1,1,"Stadium",1000);
		printAll("venue");
		System.out.println(">>Venue Created");
		
		System.out.println(); //spacing
		
		System.out.println(">>Creating Event...");		//CREATE EVENT
		super.createEvent(1,1,1,"M","01-JAN-19");
		super.createEvent(2,2,1,"M","01-JAN-19");
		super.createEvent(3,3,1,"M","01-JAN-19");
		super.createEvent(4,4,1,"M","01-JAN-19");
		super.createEvent(5,5,1,"M","01-JAN-19");
		printAll("Event");
		System.out.println(">>Event Created!");
		
		System.out.println(); //spacing
		
		System.out.println(">>Adding to Scoreboard...");//SCOREBOARD
		super.addEventOutcome(1, 1, 1, 1, 2, 1);
		printAll("Scoreboard");
		System.out.println(">>Scoreboard Results Added!");
		
		System.out.println(); //spacing
		 
		System.out.println(">>Registering Team for Events...");	//EVENT PARTICIPATION
		super.registerTeam(1, 1,"e");
		printAll("Event_participation");
		System.out.println(">>Registration complete!");
		
		System.out.println(); //spacing
	
		System.out.println(">>Droping Team Member...");	//DROP TEAM MEMBER
		super.dropTeamMember(2);
		printAll("team_member");
		System.out.println(">>Team Member Dropped!");
		
		System.out.println(); //spacing
		
		System.out.println("Login");
		
		System.out.println("Logout");
		
		System.out.println("Exit");
		
	}
	
	public void printAll (String table) throws SQLException
	{
		Statement s = databaseConnection.createStatement();
		String query = "select * from " + table;
		ResultSet rs = s.executeQuery(query);
		ResultSetMetaData m = rs.getMetaData();
		int col = m.getColumnCount();
		
		while(rs.next())
		{
			for(int i = 1; i <=col; i++)
			{
				System.out.print(rs.getString(i) + ", ");
			}
			System.out.println();
		}
	}
	

}
