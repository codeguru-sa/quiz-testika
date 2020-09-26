package gg.cs.myapp.dao;

import java.util.List;

import javax.sql.DataSource;

import gg.cs.myapp.entity.Question;

public interface TakeQuizDao {
	
	public void setDataSource(DataSource ds);
	
	public String takeQuiz(int subInt, int userId);

}
