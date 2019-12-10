package com.fsd.stock.eo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Product")
public class ProductEO {
	@Id
	private String id;
	private int price;
	private String name;
	private String description;
	private int reOrder;
	private boolean stopOrder;
	private int totalNumberOfProduct;
	private CategoryEO category;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getReOrder() {
		return reOrder;
	}
	public void setReOrder(int reOrder) {
		this.reOrder = reOrder;
	}
	public boolean isStopOrder() {
		return stopOrder;
	}
	public void setStopOrder(boolean stopOrder) {
		this.stopOrder = stopOrder;
	}
	public CategoryEO getCategory() {
		return category;
	}
	public void setCategory(CategoryEO category) {
		this.category = category;
	}
	
	public int getTotalNumberOfProduct() {
		return totalNumberOfProduct;
	}
	public void setTotalNumberOfProduct(int totalNumberOfProduct) {
		this.totalNumberOfProduct = totalNumberOfProduct;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Integer.valueOf(id);
	}
	@Override
	public boolean equals(Object arg0) {
		if(arg0 instanceof ProductEO) {

			if(this.id.equalsIgnoreCase(((ProductEO) arg0).getId())) {
				return true;
			}
		return false;
		}else
			return false;
	}

}
