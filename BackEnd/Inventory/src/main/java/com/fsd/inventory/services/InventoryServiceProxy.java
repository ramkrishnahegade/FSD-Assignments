package com.fsd.inventory.services;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fsd.inventory.EO.ProductEO;

@FeignClient(name="stockservice" )
@RibbonClient(name="stockservice" )
public interface InventoryServiceProxy {
	@GetMapping(value="stock/task/get/{name}/{description}", produces = "application/json")
	public String findProductByNameorDescription(@PathVariable("name") String name,@PathVariable("description") String description);
	
	@GetMapping(value="stock/task/getProducts", produces = "application/json")
	public String findProducts();
	
	@GetMapping(value="stock/task/get/{id}" , produces="application/json")
	public ProductEO findProductById(@PathVariable("id") String id);
	
	
}
