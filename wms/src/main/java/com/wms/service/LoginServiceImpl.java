package com.wms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wms.beans.User;
import com.wms.beans.UserActionStatus;
import com.wms.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginDao loginDao;
	
	public UserActionStatus signUp(User user) {
		return loginDao.signUp(user);
	}

	@Override
	public UserActionStatus login(User user) {
		return loginDao.login(user);
	}

}
