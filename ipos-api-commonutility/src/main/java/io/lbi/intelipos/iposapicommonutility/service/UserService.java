package io.lbi.intelipos.iposapicommonutility.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.lbi.intelipos.iposapicommonutility.entity.User;
import io.lbi.intelipos.iposapicommonutility.utility.logger.LoggerConfig;

@Service
public class UserService {

	@Autowired
	private LoggerConfig logger;
	
	public List<User> users = new ArrayList<User>();
	
	public List<User> getAllUsers()
	{
		if(users.isEmpty())
			logger.getLoggerObj().error("Users list is empty. Please add atleast one user in the list");
		else
			logger.getLoggerObj().info("Users list: " + users);
		
		return users;
	}
	
	public User addUser(User user)
	{
		User newUser = user;
		users.add(newUser);
		logger.getLoggerObj().info("User " + user + " is added in the list");
		return newUser;
	}
}
