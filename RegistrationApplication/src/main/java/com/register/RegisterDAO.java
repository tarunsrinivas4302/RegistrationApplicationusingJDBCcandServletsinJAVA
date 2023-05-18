package com.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {

	public static int saveRegDetails(RegisterDTO reg) throws ClassNotFoundException, SQLException {
		int status =0;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle1");
		
		String sql = "insert into REGISTER1 values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement st =con.prepareStatement(sql);
		
		st.setLong(1, reg.getId());
		st.setString(2, reg.getFirstname());
		st.setString(3, reg.getLastname());
		st.setInt(4, reg.getAge());
		st.setString(5, reg.getGender());
		st.setString(6,reg.getUsername());
		st.setString(7, reg.getPassword());
		st.setLong(8, reg.getPhonenumber());
		st.setString(9,reg.getCountry());
		
		
		status  =  st.executeUpdate();
		return status;
	}
	


}
