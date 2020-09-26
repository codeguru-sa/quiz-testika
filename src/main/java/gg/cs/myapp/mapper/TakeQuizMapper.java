package gg.cs.myapp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import gg.cs.myapp.entity.Question;

public class TakeQuizMapper implements RowMapper<Question>{

	public Question mapRow(ResultSet rs, int rowNum) throws SQLException{
		// TODO Auto-generated constructor stub
		Question question = new Question();
		question.setSubject(rs.getInt("subject_id"));
		question.setQuestion(rs.getString("question"));
		question.setOption1(rs.getString("choice1"));
		question.setOption2(rs.getString("choice2"));
		question.setOption3(rs.getString("choice3"));
		question.setOption4(rs.getString("choice4"));
		question.setAnswer(rs.getInt("answer"));
		
		return question;
	}

}
