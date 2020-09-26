package gg.cs.myapp.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import gg.cs.myapp.dao.LogInDao;
import gg.cs.myapp.entity.User;
import gg.cs.myapp.mapper.UserLoginMapper;


@Component
@Qualifier("loginDao")
public class LogInDaoImpl implements LogInDao {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@Override
	public int addUser(User user) {
		 int status = jdbcTemplate.update("INSERT INTO User (regtime, username, useremail, userpass) VALUES (now(), ?, ?, ?)",
		            user.getUsername(),user.getUseremail(),user.getUserpass());
		return status;
	}

	public int loginUser(String uname, String pass) {
		 String res = null;
		 String sql = null;
		 int ss = 0;
		 sql = "select user_id from User where username=? and userpass=?";
		 
		 List<User> userList = new ArrayList<User>();
		 try{
				userList = jdbcTemplate.query(sql,  new UserLoginMapper(),new Object[]{uname,pass});
				}catch(Exception e)
				{
				e.printStackTrace();		
				}
				if(!userList.isEmpty())
				{
					ss = userList.get(0).getUser_id();
				}
				else if(userList.isEmpty())
				{
					userList=null;
					ss = 0;
				}
				return ss;
			} 		
	
	
}
