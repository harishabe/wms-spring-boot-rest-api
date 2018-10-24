package com.wms.dao;

import java.sql.Connection;
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
		query = "INSERT INTO tm_userinfo (clId, userId, password) \n" + 
				" VALUES ('" + user.getName() +"', '"+user.getEmail()+"', '"+user.getPassword()+"')";
		//Add user to DB
		try {
			stat.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new UserActionStatus(true,"Signup Succesfull");
	}
}
