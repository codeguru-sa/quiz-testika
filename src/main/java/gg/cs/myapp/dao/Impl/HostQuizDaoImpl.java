package gg.cs.myapp.dao.Impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import gg.cs.myapp.dao.HostQuizDao;
import gg.cs.myapp.entity.ListQuestion;
import gg.cs.myapp.entity.Question;

@Component
@Qualifier("dao")
public class HostQuizDaoImpl implements HostQuizDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	
	String sql ="INSERT INTO question (subject_id,quiz_id,question, choice1,choice2,choice3,choice4,answer)" + 
			"  	VALUES(?,(select max(quiz_id) from quiz),?, ?,?,?,?,?);";
	@Override
	public int hostQuiz(List<Question> list) {
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// TODO Auto-generated method stub
				Question hq = list.get(i);
				for(int j=i; j<=0; j++) {
					int status = jdbcTemplate.update("INSERT INTO quiz (user_id,subject_id, quiz_name) VALUES ( ?, ?,?)",
					            hq.getUser_id(),hq.getSubject(),hq.getQuiz_name());
					if (i==0)
						break;
				}
				try {
				ps.setInt(1, hq.getSubject());
				ps.setString(2, hq.getQuestion());
				ps.setString(3, hq.getOption1());
				ps.setString(4, hq.getOption2());
				ps.setString(5, hq.getOption3());
				ps.setString(6, hq.getOption4());
				ps.setInt(7, hq.getAnswer());
				}
				catch(NumberFormatException ne) {
					 System.out.println(ne);
				}
			}
			
			@Override
			public int getBatchSize() {
				  return list.size();
			}
		   });
		return 1;

	}

}
