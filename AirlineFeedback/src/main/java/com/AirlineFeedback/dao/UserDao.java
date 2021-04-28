package com.AirlineFeedback.dao;

import com.AirlineFeedback.bean.Login;
import com.AirlineFeedback.bean.User;

public interface UserDao {
	void register(User user);

	  User validateUser(Login login);

}
