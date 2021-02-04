package com.studentRegistrar.aau.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mongodb.WriteResult;
import com.studentRegistrar.aau.model.Addition;
import com.studentRegistrar.aau.model.Customer;
import com.studentRegistrar.aau.model.User;

import order.RegisterUser;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AauController {

	private final static Logger LOGGER =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
	@Autowired
	MongoTemplate mongoTemplate;
	
	@RequestMapping(value = "/findSum", method = RequestMethod.POST)
	public Addition findSum(@RequestBody Addition addition){
		System.out.println(addition.getFirstNumber());
		addition.setTotal(addition.getFirstNumber() + addition.getSecondNumber());
		return addition;
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public User registerUser(@RequestBody User userReceived){
		LOGGER.info("Enter the controller with user:  " + userReceived.getFirstName());
		try
		{
			LOGGER.info("Enter to try:  " + userReceived.getFirstName());
			mongoTemplate.save(userReceived);
			LOGGER.info("Saved Successfully");
		}catch(Exception e){
			
		}
		return mongoTemplate.findById(userReceived.getUsername(), User.class);
	}
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public List<User> getAllUser(){
		List<User> user = new ArrayList<>();
		user = mongoTemplate.findAll(User.class);
		return user;
	}
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public void deleteUser(@RequestBody String username){
		WriteResult test = mongoTemplate.remove(new Query(Criteria.where("_id").is(username)), User.class);

	}
	@RequestMapping(value = "/viewUser", method = RequestMethod.POST)
	public User viewUser(@RequestBody String username){
		User user = mongoTemplate.findById(username, User.class);
		return user;
	}
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public boolean signinUser(@RequestBody User userReceived){
		boolean isValidUser = false;
		User user = mongoTemplate.findById(userReceived.getUsername(), User.class);
		if(user!=null){
			if(user.getUsername().equals(userReceived.getUsername()) && 
					user.getPassword().equals(userReceived.getPassword())){
					isValidUser = true;
				}
		}
		return isValidUser;
	}
}
