package gr.hua.dit.oopii.lec6.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleDBServiceCRUD {
	static Connection db_con_obj = null; //A connection (session) with a specific database. SQL statements are executed and results are returned within the context 
	//of a connection. A Connection object's database is able to provide information describing its tables, its supported SQL grammar, its stored procedures, 
	//the capabilities of this connection, and so on. This information is obtained with the getMetaData method.
	static PreparedStatement db_prep_obj = null;//An object that represents a precompiled SQL statement.
	//A SQL statement is precompiled and stored in a PreparedStatement object. This object can then be used to efficiently execute this statement multiple times.
	
	private static void makeJDBCConnection() {
		 
		try {//We check that the DB Driver is available in our project.		
			Class.forName("oracle.jdbc.driver.OracleDriver"); //This code line is to check that JDBC driver is available. Or else it will throw an exception. Check it with 2. 
			System.out.println("Congrats - Seems your oracle JDBC Driver Registered!"); 
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
			e.printStackTrace();
			return;
		}
 
		try {
			// DriverManager: The basic service for managing a set of JDBC drivers.	 //We connect to a DBMS.
			db_con_obj = DriverManager.getConnection("jdbc:oracle:thin:@oracle12c.hua.gr:1521:orcl","username","passowrd");// Returns a connection to the URL.
			//Attempts to establish a connection to the given database URL. The DriverManager attempts to select an appropriate driver from the set of registered JDBC drivers.
			if (db_con_obj != null) { 
				System.out.println("Connection Successful! Enjoy. Now it's time to CRUD data. ");				
			} else {
				System.out.println("Failed to make connection!");
			}
		} catch (SQLException e) {
			System.out.println("Oracle Connection Failed!");
			e.printStackTrace();
			return;
		}
 
	}
	private static void ReadData() throws SQLException {
	db_prep_obj = db_con_obj.prepareStatement("select * from cities");
	ResultSet  rs = db_prep_obj.executeQuery();

    while (rs.next()){
    	String city_name = rs.getString("CITY_NAME_COUNTRY_INITIALS");
    	double lat = rs.getDouble("LAT");
        double lon = rs.getDouble("LON");
        int term_1 = rs.getInt("TERM_1");
        int term_2 = rs.getInt("TERM_2");
        int term_3 = rs.getInt("TERM_3");
        int term_4 = rs.getInt("TERM_4");
        int term_5 = rs.getInt("TERM_5");
        int term_6 = rs.getInt("TERM_6");
        int term_7 = rs.getInt("TERM_7");
        int term_8 = rs.getInt("TERM_8");
        int term_9 = rs.getInt("TERM_9");
        int term_10 = rs.getInt("TERM_10");

        System.out.println("The data are: "+ city_name + " "+ lat+ " "+ lon+ " "+ term_1+ " "+ term_2+ " "+ term_3+ " "+ term_4+ " "+ term_5
        		+ " "+ term_6+ " "+ term_7+ " "+ term_8+ " "+ term_9+ " "+ term_10);        
    }
}
	
	private static void addDataToDB(String cityNameInitials, double lat, double lon, int term_1, int term_2, int term_3, int term_4, int term_5, int term_6, 
			int term_7, int term_8, int term_9, int term_10) {		 
		try {
			String insertQueryStatement = "INSERT  INTO  CITIES  VALUES  (?,?,?,?,?,?,?,?,?,?,?,?,?)";			
			db_prep_obj = db_con_obj.prepareStatement(insertQueryStatement);
			db_prep_obj.setString(1, cityNameInitials);
			db_prep_obj.setDouble(2, lat);
			db_prep_obj.setDouble(3, lon);
			db_prep_obj.setInt(4, term_1);
			db_prep_obj.setInt(5, term_2);
			db_prep_obj.setInt(6, term_3);
			db_prep_obj.setInt(7, term_4);
			db_prep_obj.setInt(8, term_5);
			db_prep_obj.setInt(9, term_6);
			db_prep_obj.setInt(10, term_7);
			db_prep_obj.setInt(11, term_8);
			db_prep_obj.setInt(12, term_9);
			db_prep_obj.setInt(13, term_10);			
			// execute insert SQL statement Executes the SQL statement in this PreparedStatement object, which must be an SQL Data Manipulation Language (DML) statement
			int numRowChanged = db_prep_obj.executeUpdate(); //either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
			System.out.println("Rows "+numRowChanged+" changed.");			
		} catch ( 
		SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args) throws SQLException {
		makeJDBCConnection();
		addDataToDB("Rome_IT", 41.8947, 12.4839, 1,2,3,4,5,6,7,8,9,10);
		addDataToDB("Athens_GR", 37.9795, 23.7162, 1,2,3,4,5,5,5,5,5,5);
		addDataToDB("London_GB", 51.5085, -0.1257, 1,1,1,1,1,6,7,8,9,10);
		ReadData();
		}
}