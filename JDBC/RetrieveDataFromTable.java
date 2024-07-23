package JDBC;
import java.io.*;
import java.sql.*;
import java.util.*;
public class RetrieveDataFromTable {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nec","nec");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select*from fiiledata");
			int pos=0;
			while(rs.next()) {
				Blob b=rs.getBlob("filecontent");
				byte[] by=b.getBytes(++pos,(int)b.length());
			Random r=new Random();
			int ran=r.nextInt(100000);
			File f=new File("D:\\21cs028\\File"+ran+".jpg");
			FileOutputStream fout=new FileOutputStream(f);
			fout.write(by);
			fout.close();
			System.out.println("Success...");
			}
			
		}
		catch(Exception obj) {
			obj.printStackTrace();
		}

	}

}
