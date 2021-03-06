package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentityGenerator;

public class ICICI_CustomPKGen extends IdentityGenerator {
	
	@Override
	public Serializable generate(SessionImplementor s, Object obj) {
		StringBuilder builder = new StringBuilder("ICICI");
		
		Connection con= s.connection();
		
		try{
			
		
			Statement maxstmt= con.createStatement();
			String sql="SELECT * FROM ICICIAccount ORDER BY acno DESC LIMIT 1";
		
			ResultSet rs=   maxstmt.executeQuery(sql);
			//System.out.println(rs.next());
			
			if (rs.next()){
				
				String acno=rs.getString(1);
				System.out.println(acno);
				int i= Integer.parseInt(acno.substring(acno.lastIndexOf('I')+1));
				i++;
				builder.append(i);
				
				System.out.println(builder.toString());
			}
			else{
				builder.append(1000);
			}
		
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return builder.toString();
	}

}
