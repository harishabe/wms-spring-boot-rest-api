package com.wms.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.beans.User;
import com.wms.beans.UserActionStatus;
import com.wms.dao.LoginDao;

@Service
public interface LoginService {	
	public UserActionStatus signUp(User user);

	public UserActionStatus login(User user);

}
