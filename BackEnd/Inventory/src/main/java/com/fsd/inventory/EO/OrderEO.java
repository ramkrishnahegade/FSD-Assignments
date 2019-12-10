package com.fsd.inventory.EO;

public class OrderEO {
private ProductEO productEO;
private int totalNumber;
private int orderPrice;
public ProductEO getProductEO() {
	return productEO;
}
public void setProductEO(ProductEO productEO) {
	this.productEO = productEO;
}
public int getTotalNumber() {
	return totalNumber;
}
public void setTotalNumber(int totalNumber) {
	this.totalNumber = totalNumber;
}

public int getOrderPrice() {
	return this.productEO.getPrice()*this.totalNumber;
}
public void setOrderPrice(int orderPrice) {
	this.orderPrice = orderPrice;
}
@Override
	public int hashCode() {
		// TODO Auto-generated method stub
	 int hashCode = 17;
	    if (this.productEO.getId() != null) {
	        hashCode = hashCode * 31 + this.productEO.getId().hashCode();
	    }
	return hashCode;
	}

@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
	if(arg0 instanceof OrderEO) {
		if(this.productEO.getId().equalsIgnoreCase(((OrderEO) arg0).productEO.getId()))
			return true;
		else 
			return false;
		
	}
		
		return false;
	}

}
