package com.fellowshopper.core.user;

import com.fellowshopper.core.Requestor;
import com.fellowshopper.core.User;

public class UserManagerImpl implements UserManager {

	@Override
	public void addUser() {
		
		
		User user = new Requestor("Avinash", "Vutukuri", "718-309-2875");
		
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
