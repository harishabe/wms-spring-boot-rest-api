package com.wms.dao;



import org.springframework.stereotype.Repository;

import com.wms.beans.User;
import com.wms.beans.UserActionStatus;

@Repository
public interface LoginDao {
	public UserActionStatus signUp(User user);

	public UserActionStatus login(User user);
}
