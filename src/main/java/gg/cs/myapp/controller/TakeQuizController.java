package gg.cs.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import gg.cs.myapp.entity.QuizName;
import gg.cs.myapp.service.TakeQuizService;

@RestController
@JsonIgnoreProperties
@CrossOrigin(origins = "http://localhost:4200")
public class TakeQuizController {
	
	@Autowired
	TakeQuizService service;
	
	@RequestMapping(value ="/takeQuiz",method = RequestMethod.POST)
	public @ResponseBody String takeQuiz(@RequestBody String val)throws Exception {
		QuizName obj = new QuizName();
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		obj = mapper.readValue(val, QuizName.class);
		int subInt = (Integer)obj.getValue();
		int userId = Integer.parseInt(obj.getUserId());
		return service.takeQuizService(subInt, userId);
	}

}
