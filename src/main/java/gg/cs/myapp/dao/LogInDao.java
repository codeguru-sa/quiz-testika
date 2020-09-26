package gg.cs.myapp.dao;

import gg.cs.myapp.entity.User;

public interface LogInDao {

	public int addUser(User user);

	public int loginUser(String uname, String pass);

}
