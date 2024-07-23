package JDBC;
import java.util.*;
import java.sql.*;
public class ReadDataFromTable {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nec","nec");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select*from customer where cust_id='"+"c2"+"'");
			while(rs.next()) {
				String cust_id=rs.getString("cust_id");
				String cust_name=rs.getString("cust_name");
				String location=rs.getString("loc");
				String email_id=rs.getString("email_id");
				System.out.println("Customer ID: "+cust_id);
				System.out.println("Customer name: "+cust_name);
				System.out.println("Location: "+location);
				System.out.println("Email ID: "+email_id);
				System.out.println("****************************************");
			}
		}
		catch(Exception obj) {
			obj.printStackTrace();
		}
	}

}
