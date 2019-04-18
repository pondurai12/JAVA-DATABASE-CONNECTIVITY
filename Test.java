import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "manager");
		
		Statement statement = connection.createStatement();
		System.out.println("connection started..."+connection);
		
		PreparedStatement preparedstatement = connection.prepareStatement("insert into king values(?,?,?,?)");
		Scanner scan  = new Scanner(System.in);
		while(true) {
			System.out.println("Enter sno");
			int sno = scan.nextInt();
			
			System.out.println("Enter name");
			String name = scan.next();
			
			System.out.println("Enter state");
			String state = scan.next();
			
			System.out.println("Enter pincode");
			int pincode = scan.nextInt();
			
			preparedstatement.setInt(1, sno);
			
			preparedstatement.setString(2, name);
			
			preparedstatement.setString(3, state);
			
			preparedstatement.setInt(4, pincode);
			
			preparedstatement.execute();
			
			System.out.println("Values inserted successfully........do you want 1 more record yes/no");
			
			String option = scan.next();
			if(option.equals("no")) {
				break;
			}
	}
		
		connection.close();
		statement.close();
		scan.close();
		System.out.println("Connection close succesfully......");

}
}
