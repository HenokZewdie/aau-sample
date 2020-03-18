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

import com.mongodb.BasicDBObject;
import com.mongodb.WriteResult;
import com.studentRegistrar.aau.model.Addition;
import com.studentRegistrar.aau.model.Branch;
import com.studentRegistrar.aau.model.Customer;
import com.studentRegistrar.aau.model.User;

import order.OrderResponse;
import order.RegisterUser;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class OrderController {

	private final static Logger LOGGER =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
	@Autowired
	MongoTemplate mongoTemplate;
	
	@RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
	public void order() {
		RegisterUser userReg = new RegisterUser();
		Customer customer = userReg.customer();
		mongoTemplate.save(customer);
	}

	@RequestMapping(value = "/getCustomer", method = RequestMethod.POST)
	public List<Customer> registerUser(@RequestBody String name){
		List<Customer> custList = null;
		try
		{
			custList  = mongoTemplate.find(new Query(Criteria.where("custName").is(name)), Customer.class);
		    
			for(Customer cust: custList){
				System.out.println("The User is : " + cust.getCustName() + "  " + cust.getCustLastName()
				+ " With phone number  " + cust.getPhone() + " in the branch: " + cust.getBranch());
			}
			
		
		}catch(Exception e){
			
		}
		return custList;
	}
	
	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
	public List<Customer> getAllUser(){
		List<Customer> user = new ArrayList<>();
		user = mongoTemplate.findAll(Customer.class);
		for(Customer cust: user){
			System.out.println("The User is : " + cust.getCustName() + "  " + cust.getCustLastName()
			+ " With phone number  " + cust.getPhone() + " in the branch: " + cust.getBranch());
		}
		return user;
	}
	
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
	public void deleteUser(@RequestBody String username){
		WriteResult test = mongoTemplate.remove(new Query(Criteria.where("_id").is(username)), User.class);
	}
	
	
	
/*	@RequestMapping(value = "/registerBranch", method = RequestMethod.POST)
	public void regBranch() {
		RegisterUser custReg = new RegisterUser();
		Branch branch = custReg.branch();
		mongoTemplate.save(branch);
	}*/
		
}
