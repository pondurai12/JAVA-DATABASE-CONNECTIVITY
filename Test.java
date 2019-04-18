package com.dss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Step 1: Load the driver(It automatically registered driver called DriverManager Service)
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		System.out.println("Driver Loading process completed.....");
		
		//Step 2:create connection
		
		Connection connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "manager");
		
		System.out.println("Connection created Succesfully"+connection);
		
		// Step 3: Write the query
		
		//String query2= "create table king(sno number,name varchar2(20),state varchar2(10),pincode number)";
		
	String q2 = "insert into king values(1,'hello','tn',636201)";
	
	String q3 = "select*from king";
		
		//Step 4:Process the query
		
	Statement statement = connection.createStatement();
//		
	//int x = statement.executeUpdate(query1);
//		System.out.println("Table created successfully"+x);
		
	
	//Step 4: Execute the query
		int y = statement.executeUpdate(q2);
	
	System.out.println("Table created successfully"+y);

	ResultSet rs = statement.executeQuery(q3);
//	while(rs.next()) {
//		System.out.println(rs.getString(1));
//		
//	}
	System.out.println("executed query ");
	
	//Step 5:Close the connection
	statement.close();
	connection.close();
	
	System.out.println("Connection closed succesfully");
	}

}
