package com.dss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Test {

	public static void main(String[] args) {
		
		Connection connection=null;
		Statement statement=null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println(10/0);
			System.out.println("Driver Loading process completed.....");
			
			//Step 2:create connection
			
			 connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "manager");
			
			System.out.println("Connection created Succesfully"+connection);
			System.out.println("Resources declaraton");
			
			

			
		String q1 = "insert into king values(3,'ssss','salem',3736)";
		String q2 = "select*from king";
		
			 statement = connection.createStatement();
			
			statement.executeUpdate(q1);
		ResultSet rs=	statement.executeQuery(q2);
			while(rs.next()) {
				System.out.println(" "+rs.getString("name")+" "+rs.getString("sno")+" "+rs.getString("pincode"));
			}
			
			statement.execute(q2);
			
			System.out.println("data inseerted"+statement.execute(q2));
			
		
			
		}catch(ClassNotFoundException  | SQLException e) {
			e.printStackTrace();
			System.out.println("handled exception");
			
		}finally {
			try {
				if(connection!=null) {
		connection.close();
				}
				if(statement!=null) {
		statement.close();
				}
		System.out.println("finally resources closed");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
}
