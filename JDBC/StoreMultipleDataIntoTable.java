package JDBC;
import java.util.*;
import java.sql.*;
public class StoreMultipleDataIntoTable {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nec","nec");
			Scanner sc=new Scanner(System.in);
			String user_value=" ";
			do {
				System.out.println("Enter Customer ID: ");
				String cust_id=sc.nextLine();
				System.out.println("Enter Customer Name: ");
				String cust_name=sc.nextLine();
				System.out.println("Enter location: ");
				String loc=sc.nextLine();
				System.out.println("Enter Email ID: ");
				String email_id=sc.nextLine();
				PreparedStatement ps=con.prepareStatement("insert into customer values(?,?,?,?)");
				ps.setString(1,cust_id);
				ps.setString(2,cust_name);
				ps.setString(3,loc);
				ps.setString(4,email_id);
				ps.addBatch();
				System.out.println("Enter your choice(yes/no): ");
				user_value=sc.nextLine();
				ps.executeBatch();
				
			}while(user_value.equals("yes"));
			System.out.println("Success...");
			sc.close();
		}
		catch(Exception obj) {
			obj.printStackTrace();
		}
	}

}
