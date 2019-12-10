package com.fsd.stock.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.fsd.stock.eo.ProductEO;
import com.fsd.stock.services.StockServices;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/task")
public class StockController {
	private static Logger log = LoggerFactory.getLogger(StockController.class);
	@Autowired
	public StockServices stockServices;
	
	@PostMapping(value="/addProduct",consumes = "application/json" )
	public void addProduct(@RequestBody ProductEO productEO) {
		System.out.println("Entered to add product");
		stockServices.addProduct(productEO);
	}
	
	@GetMapping(path="/get/{name}/{description}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductEO> getProductsByNameandDescription(@PathVariable("name") String name,@PathVariable("description") String description){
		return stockServices.findProductByName(name, description);
	}
	@GetMapping(path="/getProducts",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductEO> getProducts(){
		log.info("============ Stockservice:Getting all Products");
		return stockServices.findProducts();
	}
	@GetMapping(path="/get/{id}")
	public ProductEO getProductById(@PathVariable("id")String id) {
		return stockServices.findProductById(id);
	}
	@GetMapping("/test")
	public String test() {
		return "Successss";
	}
	

}
