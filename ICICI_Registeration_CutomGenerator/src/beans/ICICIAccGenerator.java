package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentityGenerator;

public class ICICIAccGenerator extends IdentityGenerator {
	
	StringBuilder builder = new StringBuilder("ICICI");  
	
	@Override
	public Serializable generate(SessionImplementor s, Object obj) {
		
		//get next sequence
		//append sequence to ICICI
		//Send to table
		//create sequence icici_sequence
		//start with 1
		//increment by 1
		//nocycle
		//nocache
		
		 Connection con=s.connection();
		 try {
			Statement sequencetstmt= con.createStatement();
			String sql="values next value for db2admin5.icici_sequence"; //for getting next val from sequence in db2
			ResultSet rs = sequencetstmt.executeQuery(sql);
			
			if (rs.next()){
				builder.append(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return builder.toString();
	}

}
