package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StringSubStr {
	
	public static void main(String[] args) {
		
		StringBuilder builder = new StringBuilder("ICICI");
		
		System.out.println("Resgistering mysql Driver");
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		try {
			
			String url="jdbc:mysql://localhost/Mas";
			String user="root";
			String pwd="root";
			Connection con = DriverManager.getConnection(url, user, pwd);
			Statement maxstmt= con.createStatement();
			String sql="SELECT * FROM ICICIAccount ORDER BY acno DESC LIMIT 1";
		
			ResultSet rs= maxstmt.executeQuery(sql);
			//System.out.println(rs.next());
			
			if (rs.next()){
				
				String acno=rs.getString(1);
				System.out.println(acno);
				char ch='I';
				int findex= acno.lastIndexOf(ch)+1;
				//int lindex= acno.length()+1;
				System.out.println(findex);
				String nacno=acno.substring(findex);
				System.out.println(nacno);
				int i= Integer.parseInt(nacno);
				i++;
				builder.append(i);
				
				System.out.println(builder.toString());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
