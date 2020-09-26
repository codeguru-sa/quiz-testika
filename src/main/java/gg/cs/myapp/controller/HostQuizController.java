package gg.cs.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import gg.cs.myapp.entity.Question;
import gg.cs.myapp.service.HostQuizService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HostQuizController {

	 @Autowired
	 HostQuizService service;

	@RequestMapping(value ="/hostform",method = RequestMethod.POST)
	public int hostQuiz(@RequestBody String questions) throws Exception {
		System.out.print(questions);
		Question que = new Question();
		ObjectMapper mapper = new ObjectMapper();
		TypeFactory typeFactory = mapper.getTypeFactory();
		List<Question> list = mapper.readValue(questions, new TypeReference<List<Question>>() { });
		return service.addQuiz(list);      
	}
}
		