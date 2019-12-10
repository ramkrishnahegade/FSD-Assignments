package com.fsd.inventory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.ExceptionService.BusinessValidationException;
import com.fsd.inventory.EO.CustomerEO;
import com.fsd.inventory.EO.OrderLogEntriesEO;
import com.fsd.inventory.repository.InventoryRepository;
import com.fsd.inventory.services.CustomerServices;
import com.fsd.inventory.services.InventoryServices;
import com.fsd.inventory.services.OrderService;

@RestController
@RequestMapping
@CrossOrigin("*")
public class InventoryController {
 
	private static Logger log = LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired
	private InventoryServices inventoryServices;
	
	@Autowired
	private CustomerServices customerServices;
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping(path="/addCustomer",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addCustomer(@RequestBody CustomerEO customerEO) throws BusinessValidationException {
		customerServices.addCustomer(customerEO);	
	}
	@GetMapping("getCustomer/{username}/{password}")
	public ResponseEntity<CustomerEO> findCustomerByUsernameandPassword(@PathVariable("username") String username ,@PathVariable("password") String password )
	throws BusinessValidationException{
	CustomerEO customerEO=	customerServices.findCustomerbyUsernameandPwd(username, password);
	
	if(customerEO!=null) {
		return new ResponseEntity<CustomerEO>(customerEO,HttpStatus.OK);
	}else {
		throw new BusinessValidationException("UserName and Password is Incorrect");
	}
	
	}
	@GetMapping("getCustomer/{username}")
	public CustomerEO findCustomerByUsername(@PathVariable("username") String username ) {
		return customerServices.findCustomerbyUsername(username);
	}
	
	
	@GetMapping("/getProducts/{name}/{description}")
	public String findProductByNameOrDescription(@PathVariable("name") String name,@PathVariable("description") String description) {
		
		return inventoryServices.findProductByNameorDescription(name, description);
	}
	@GetMapping("/getProducts")
	public String findProductByNameOrDescription() {
		log.info("========== Get all Products ==== ");
		return inventoryServices.findProducts();
	}
	
	@PostMapping(path="addOrder/{username}/{productid}")
	public void addOrder(@PathVariable("username")String username, @PathVariable("productid")String productId) {
		 orderService.addProduct(username, productId);
	}

	@GetMapping("getOrders/{username}")
	public ResponseEntity<OrderLogEntriesEO> getOrders(@PathVariable("username")String username) {
		OrderLogEntriesEO entriesEO=  orderService.getOrder(username);
		return new ResponseEntity<OrderLogEntriesEO>(entriesEO,HttpStatus.OK);
		
	}
}
