package com.wms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.wms.beans.User;
import com.wms.beans.UserActionStatus;
import com.wms.operations.DBConnection;

@Repository
public class LoginDaoImpl implements LoginDao {
	
	private DBConnection dbConn;
	private static Connection conn;

	private static Statement stat;
	
	private String query;
	
	static {
		
	}
	
	public UserActionStatus signUp(User user) {
		dbConn = new DBConnection();
		System.out.println("Setting up the db connection:"+ dbConn.connectWMS());
		conn = dbConn.connectWMS();
		try {
			stat = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO: Check if the user already exists
		query = "INSERT INTO tm_userinfo (slNo, clId, userId, password) \n" + 
				" VALUES ('" + user.getId() +"','" + user.getName() +"', '"+user.getEmail()+"', '"+user.getPassword()+"')";
		//Add user to DB
		try {
			stat.executeUpdate(query);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new UserActionStatus(false,"There was some issue while creating user. Please try again later.");
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new UserActionStatus(true,"Thank you for registering to WMS.");
	}

	@Override
	public UserActionStatus login(User user) {
		dbConn = new DBConnection();
		System.out.println("Setting up the db connection:"+ dbConn.connectWMS());
		conn = dbConn.connectWMS();
		try {
			stat = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO: Check if the user already exists
			String queryString = "SELECT * FROM tm_userinfo where clId='" + user.getName() +"' and password='" + user.getPassword() + "'";
			System.out.println("Query:" + queryString);
	        //set this values using PreparedStatement
	        
	        try {
	        	ResultSet results = stat.executeQuery(queryString); //where ps is Object of PreparedStatement
	        	
				if(!results.next()) {
					return new UserActionStatus(false,"Wrong Username and Password.");  
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return new UserActionStatus(true,"Login successfull.");
	}
}
