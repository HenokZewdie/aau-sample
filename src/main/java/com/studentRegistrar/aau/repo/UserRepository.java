package com.studentRegistrar.aau.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.studentRegistrar.aau.model.User;

	public interface UserRepository extends MongoRepository<User, Long>{

	    User findByUsername(String username);

	}
