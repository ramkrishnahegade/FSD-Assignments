package com.fsd.inventory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fsd.inventory.EO.OrderLogEntriesEO;

public interface OrderRepository extends MongoRepository<OrderLogEntriesEO,String> {

	public OrderLogEntriesEO findByUsername(String username);
	
	
}
