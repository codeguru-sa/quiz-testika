package gg.cs.myapp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import gg.cs.myapp.entity.QuizName;

public class QuizNameMapper implements RowMapper<QuizName>{

	@Override
	public QuizName mapRow(ResultSet rs, int rowNum) throws SQLException {
		QuizName quizName = new QuizName();
		
		quizName.setQuizName(rs.getString("quiz_name"));
		
		return quizName;
	}

}
