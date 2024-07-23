package JDBC;
import java.io.*;
import java.sql.*;
import java.util.*;
public class StoreFileIntoTable {

	public static void main(String[] args) {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nec","nec");
			File f=new File("D:\\21cs028\\lord shiva.jpg");
			FileInputStream fin=new FileInputStream(f);
			PreparedStatement ps=con.prepareStatement("insert into fiiledata values(?,?)");
			ps.setString(1,"f-1");
			ps.setBinaryStream(2, fin, fin.available());
			int res=ps.executeUpdate();
			if(res>0) {
				System.out.println("Image Added Succesfully...");
			}
		}
		catch(Exception obj) {
			obj.printStackTrace();
		}

	}

}
