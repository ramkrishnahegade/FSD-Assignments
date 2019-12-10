package com.fsd.stock.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.fsd.stock.eo.ProductEO;

public interface StockRepository extends MongoRepository<ProductEO, String> {

	public List<ProductEO> findByNameIgnoreCaseLikeOrDescriptionIgnoreCaseLike(String name,String description);
}
