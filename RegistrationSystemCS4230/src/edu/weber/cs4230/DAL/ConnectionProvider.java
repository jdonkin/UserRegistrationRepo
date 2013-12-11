package edu.weber.cs4230.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import static edu.weber.cs4230.DAL.Provider.*;

public class ConnectionProvider {
	static Connection con = null;
	static {
		try{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			
		}
		catch(Exception e){
			System.out.println("Exception is :" + e);
		}
		
		
		}
	public static Connection getCon(){
		return con;
		
	}

}
