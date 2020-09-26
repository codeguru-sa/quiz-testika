/**
 * 
 */
package gg.cs.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import gg.cs.myapp.dao.LogInDao;
import gg.cs.myapp.entity.User;

public interface LogInService {
	
	public int addUser(User user);

	public int loginUser(String uname, String pass);

}
