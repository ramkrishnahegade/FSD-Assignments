package com.fsd.inventory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fsd.inventory.EO.CustomerEO;

public interface CustomerRepository extends MongoRepository<CustomerEO,String> {

	public CustomerEO findByUsername(String usename);
	public CustomerEO findByUsernameAndPassword(String usename,String password);
}
