package gi3.MazdaTools.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnect {

	
	public static Connection Connect() throws SQLException
	{	
		try {
			String databaseUser ="RuxcMZpztv";
			String databaseMDP ="dgqCVPbkvq";
			String databaseName ="RuxcMZpztv";
			String url ="jdbc:mysql://remotemysql.com/"+databaseName;
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con =DriverManager.getConnection(url,databaseUser,databaseMDP);
				return con;
		} catch (ClassNotFoundException | SQLException e) {
		}
		return null;
		
		
	}
}
