package gr.hua.dit.oopii.lec6.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class DBServiceCRUD {
	static Connection db_con_obj = null;
	static PreparedStatement db_prep_obj = null;
	
	private static void makeJDBCConnection() {
		 
		try {
			//We check that the DB Driver is available in our project.
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Congrats - Seems your MySQL JDBC Driver Registered!"); 
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
			e.printStackTrace();
			return;
		}
 
		try {
			// DriverManager: The basic service for managing a set of JDBC drivers.	 //We connect to a DBMS.
			//Using the DriverManager, we can have many connections to different DBMS
			db_con_obj = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_test","username", "password");
			if (db_con_obj != null) {
				System.out.println("Connection Successful! Enjoy. Now it's time to push data");
			} else {
				System.out.println("Failed to make connection!");
			}
		} catch (SQLException e) {
			System.out.println("MySQL Connection Failed!");
			e.printStackTrace();
			return;
		}
 
	}
	private static void getDataFromDB() {
		 
		try {
			// A simple MySQL Select Query 
			String getQueryStatement = "SELECT * FROM dt_amount;";
			
			// We make a statement to the connected DBMS. We pass to the statement a query.
			db_prep_obj = db_con_obj.prepareStatement(getQueryStatement); 
 
			// Execute the Query, and get a java ResultSet
			ResultSet rs = db_prep_obj.executeQuery(); 
			
			// Let's iterate through the java ResultSet
			while (rs.next()) {
				Integer name = rs.getInt("ID");
				//Float address = rs.getFloat("VALUE");//  .getString("Address");
				//int employeeCount = rs.getInt("PSS_DIAGNOSIS_DATE_ID");
				//int website = rs.getInt("PSS_SYMPTOMS_ONSETDATE_ID");
 
				// Simply Print the results
				System.out.println("name is:"+name);//"%s, %s, %s, %s\n", name, address, employeeCount, website);
			}
 
		} catch (
 
		SQLException e) {
			e.printStackTrace();
		}
 
	}
	public static void main(String [] args) {
		makeJDBCConnection();
		getDataFromDB();
	}
}
