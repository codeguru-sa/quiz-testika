package gg.cs.myapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gg.cs.myapp.dao.LogInDao;
import gg.cs.myapp.entity.User;
import gg.cs.myapp.service.LogInService;

@Service("logInService")
public class LogInServiceImpl implements LogInService {

	
	@Autowired
	private LogInDao loginDao;
	
	@Override
	public int addUser(User user) {
	
		return loginDao.addUser(user);
		
	}

	@Override
	public int loginUser(String uname, String pass) {
		
		return loginDao.loginUser(uname,pass);
	}
	

}
