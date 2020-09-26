package gg.cs.myapp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import gg.cs.myapp.entity.User;

public class UserLoginMapper implements RowMapper<User> {
	
public User mapRow(ResultSet rs, int rowNum) throws SQLException{
		User usermap = new User();
		usermap.setUser_id(rs.getInt("user_id"));
		
		return usermap;
	}

}
