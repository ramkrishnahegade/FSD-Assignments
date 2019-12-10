package com.fsd.inventory.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class InventoryServices {
	private static Logger log = LoggerFactory.getLogger(InventoryServices.class);
	@Autowired
	private InventoryServiceProxy inventoryServiceProxy;
	
	public String findProductByNameorDescription(String name,String description) {
		return inventoryServiceProxy.findProductByNameorDescription(name, description);
	}
	
	public String findProducts() {
		log.info("========== Get all Products ==== ");
		return inventoryServiceProxy.findProducts();
	}
}
