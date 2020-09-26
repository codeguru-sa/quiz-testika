package gg.cs.myapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gg.cs.myapp.dao.HostQuizDao;
import gg.cs.myapp.entity.Question;
import gg.cs.myapp.service.HostQuizService;

@Service("service")
public class HostQuizServiceImpl implements HostQuizService{

	@Autowired
	HostQuizDao dao;

	@Override
	public int addQuiz(List<Question> list) {
		return dao.hostQuiz((List<Question>) list);
	}
		

}
