package JDBC;
import java.util.*;
import java.sql.*;
public class StoreDataIntoTable1 {

	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter no of data: ");
			int num=sc.nextInt();
			sc.nextLine();
			for(int i=0;i<num;i++) {
			System.out.println("Enter Customer ID: ");
			String cust_id=sc.nextLine();
			System.out.println("Enter Customer name: ");
			String cust_name=sc.nextLine();
			System.out.println("Enter location: ");
			String location=sc.nextLine();
			System.out.println("Enter Email ID: ");
			String email_id=sc.nextLine();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nec","nec");
			String query="insert into customer values('"+cust_id+"','"+cust_name+"','"+location+"','"+email_id+"')";
			PreparedStatement ps=con.prepareStatement(query);
			int res=ps.executeUpdate();
			if(res>0) {
				System.out.println("Success...");
			}
			}
		}
		catch(Exception obj) {
			obj.printStackTrace();
		}

	}

}
