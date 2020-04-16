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
			System.out.println("Congrats - Seems your MySQL JDBC Driver Registered!"); 
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
			e.printStackTrace();
			return;
		}
 
		try {
			// DriverManager: The basic service for managing a set of JDBC drivers.	 //We connect to a DBMS.
			db_con_obj = DriverManager.getConnection("jdbc:oracle:thin:@oracle12c.hua.gr:1521:orcl","username","password");// Returns a connection to the URL.
			//Attempts to establish a connection to the given database URL. The DriverManager attempts to select an appropriate driver from the set of registered JDBC drivers.
			if (db_con_obj != null) { 
				System.out.println("Connection Successful! Enjoy. Now it's time to CRUD data. ");
				
			} else {
				System.out.println("Failed to make connection!");
			}
		} catch (SQLException e) {
			System.out.println("MySQL Connection Failed!");
			e.printStackTrace();
			return;
		}
 
	}
	private static void ReadData() throws SQLException {
	db_prep_obj = db_con_obj.prepareStatement("select * from cities");
	ResultSet  rs = db_prep_obj.executeQuery();

    while (rs.next()){
        String cityName = rs.getString("cityName");
        int museums = rs.getInt("museums");
        int cafes = rs.getInt("cafes");
        int restaurants = rs.getInt("restaurants");
        int bars = rs.getInt("bars");
        double lat = rs.getDouble("lat");
        double lon = rs.getFloat("lon");
        String weather = rs.getString("weather");
        int wordCount = rs.getInt("wordCount");
        System.out.println("The data are: "+ cityName + " "+ cafes );
        
    }
}
	
	public static void main(String [] args) throws SQLException {
		makeJDBCConnection();
		//ReadData();
		}
}