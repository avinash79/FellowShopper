package com.fellowshopper.core.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.fellowshopper.core.DBConnection;
import com.fellowshopper.core.Requestor;
import com.fellowshopper.core.User;

public class UserManagerImpl implements UserManager {

	@Override
	public void addUser(User user) {
		
		Connection conn = null;
		Statement stmt = null;
		
	//	User user = new Requestor("Avinash", "Vutukuri", "718-309-2875");
		conn = DBConnection.getConnection();
		
		try {
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO user (username,first_name,last_name,phone_num,user_type) " +
	                   "VALUES ( '" + user.getUserName() +"', '" + user.getFirstName() +"', '" + user.getLastName() +"', '" 
					+ user.getPhoneNumber() +"', 'Requestor' )";
			
			System.out.println("Query: "+sql);
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//persist this user to DB

	}

	@Override
	public void modifyUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

}
