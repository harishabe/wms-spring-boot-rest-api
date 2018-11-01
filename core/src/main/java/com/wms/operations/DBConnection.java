package com.wms.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wms.util.DataSourceConfig;

@Component
public class DBConnection {	
	
	@Autowired
	private DataSourceConfig dbConfig;
	
	public Connection connectWMS() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		System.out.println("Creating connection object using " + dbConfig + ".");
		Connection con = null; 
		/*String url=dbConfig.getUrl();
		String user = dbConfig.getUser();
		String password  = dbConfig.getPassword();*/
		String url =  "jdbc:mysql://117.247.3.155:3306/wtms_new?useSSL=false";
			String	 user = "srhramsanjay";
				String	 password =  "ramsan@123";
		System.out.println("Using " + user + " user for connection");
		try { // opening database connection to MySQL server
			con = DriverManager.getConnection(url, user, password); 
		}

	 catch (SQLException sqlEx) {
        sqlEx.printStackTrace();
    } 
		return con;
	}

}
