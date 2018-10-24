package com.wms.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.wms.util.DataSourceConfig;


public class DBConnection {	
	
	@Autowired
	private DataSourceConfig dbConfig;
	
	public Connection connectWMS() {
		System.out.println("Creating connection object using " + dbConfig + ".");
		Connection con = null; 
		String url=dbConfig.getUrl();
		String user = dbConfig.getUser();
		String password  = dbConfig.getPassword();
		System.out.println("Using " + user + " user for connection");
		try { // opening database connection to MySQL server
			con = DriverManager.getConnection(url, user, password); 
		}

	 catch (SQLException sqlEx) {
        sqlEx.printStackTrace();
    } finally {
        //close connection ,stmt and resultset here
        try { con.close(); } catch(SQLException se) { /*can't do anything */ }        
    }
		return con;
	}

}
