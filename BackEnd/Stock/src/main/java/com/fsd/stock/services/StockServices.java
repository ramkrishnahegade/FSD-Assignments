package com.fsd.stock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.stock.eo.ProductEO;
import com.fsd.stock.repository.StockRepository;

@Service
public class StockServices {
	
	@Autowired
	public StockRepository stockRepository;
	
	  public void addProduct(ProductEO productEO) {
	  stockRepository.insert(productEO);
	  }
	  
	  public List<ProductEO> findProductByName(String name,String description) {
		  return stockRepository.findByNameIgnoreCaseLikeOrDescriptionIgnoreCaseLike(name,description);
	  }
	  
	  public List<ProductEO> findProducts(){
		  return stockRepository.findAll();
	  }
	 
	  public ProductEO findProductById(String id) {
		  return stockRepository.findById(id).get();
	  }
}
