import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test2 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "manager");
		
		Statement statement = connection.createStatement();
		System.out.println("connection started..."+connection);
		
		PreparedStatement preparedstatement = connection.prepareStatement("update king set ");
		Scanner scan  = new Scanner(System.in);

		
		connection.close();
		statement.close();
		scan.close();
		System.out.println("Connection close succesfully......");

}
}
