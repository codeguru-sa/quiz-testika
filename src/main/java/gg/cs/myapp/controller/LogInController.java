package gg.cs.myapp.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gg.cs.myapp.entity.User;
import gg.cs.myapp.service.LogInService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LogInController {
	
	@Autowired
	private LogInService logInService;
	
	@RequestMapping("/")
	public ModelAndView getFirst() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value ="/register",method = RequestMethod.POST)
	public int registerUser(@RequestBody String userDetails) throws JsonMappingException, JsonProcessingException,IOException {
      User obj = new User();
        ObjectMapper mapper = new ObjectMapper();
        obj = mapper.readValue(userDetails, User.class);
		return logInService.addUser(obj);
	}

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public 	@ResponseBody int loginUser(@RequestBody String userLogDetails) throws JsonMappingException, JsonProcessingException,IOException {
		User obj = new User();
		ObjectMapper mapper=new ObjectMapper();
		obj=mapper.readValue(userLogDetails, User.class);
		String uname = obj.getUsername();
		String pass = obj.getUserpass();
		int res = logInService.loginUser(uname,pass);
		return res;
	}
}
