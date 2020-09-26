package gg.cs.myapp.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import gg.cs.myapp.dao.TakeQuizDao;
import gg.cs.myapp.entity.QuizName;
import gg.cs.myapp.mapper.QuizNameMapper;

@Component
@Qualifier("takeQuizDao")
public class TakeQuizDaoImpl implements TakeQuizDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	DataSource dataSource;
	
	 public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplate = new JdbcTemplate(dataSource);
	  }

	@Override
	public String takeQuiz(int subInt, int userId) {
		String res = null;
		String sql = "select quiz_name from quiz where user_id!=? and subject_id=?";
		List<QuizName> list = new ArrayList<QuizName>();
		try {
		list = jdbcTemplate.query(sql,new QuizNameMapper(),new Object[]{userId,subInt} );
		}catch(Exception e)
		{
		e.printStackTrace();		
		}
		if(!list.isEmpty())
		{
			res = list.toString();
		}
		else if(list.isEmpty())
		{
			list= null;
			res = null;;
		}
		return res;
	}

}
