package gg.cs.myapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gg.cs.myapp.dao.TakeQuizDao;
import gg.cs.myapp.entity.Question;
import gg.cs.myapp.service.TakeQuizService;

@Service("takeQuizService")
public class TakeQuizServiceImpl implements TakeQuizService {

	@Autowired
	TakeQuizDao dao;
	
	public TakeQuizServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String takeQuizService(int subInt, int userId) {
		
		return dao.takeQuiz(subInt, userId);
	}

}
