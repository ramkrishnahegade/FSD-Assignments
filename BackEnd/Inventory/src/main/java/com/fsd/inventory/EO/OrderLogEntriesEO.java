package com.fsd.inventory.EO;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.bouncycastle.math.ec.rfc7748.X25519;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="OrderLogEntriesEO")
public class OrderLogEntriesEO {
    @Id
	private String id;
	private Timestamp	timestamp; 
	private Date date  ;
	@Indexed(unique = true)
	private String username;
	private List<OrderEO> orderEOs;
	private int totalPrice;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getTotalPrice() {
		int j=0;
		for (OrderEO orderEO : orderEOs) {
			j=j+orderEO.getOrderPrice();
		}
		this.totalPrice=j;
	return totalPrice;

	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<OrderEO> getOrderEOs() {
		return orderEOs;
	}
	public void setOrderEOs(List<OrderEO> orderEOs) {
		this.orderEOs = orderEOs;
	}
	
	

}
