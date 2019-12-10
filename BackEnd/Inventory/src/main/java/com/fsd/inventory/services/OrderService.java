package com.fsd.inventory.services;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.inventory.EO.OrderEO;
import com.fsd.inventory.EO.OrderLogEntriesEO;
import com.fsd.inventory.EO.ProductEO;
import com.fsd.inventory.repository.OrderRepository;
@Service
public class OrderService {
	private static Logger log = LoggerFactory.getLogger(OrderService.class);
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private InventoryServiceProxy inventoryServiceProxy;
	
	public void addProduct(String username, String productId) {
		OrderLogEntriesEO entriesEO;
		OrderEO chkOrderEO=new OrderEO();
		ProductEO chkProduct=inventoryServiceProxy.findProductById(productId);
		chkOrderEO.setProductEO(chkProduct);
		OrderEO orderEO=null;
		List<OrderEO> orderEOs=null;
		chkProduct.setId(productId);
		entriesEO=orderRepository.findByUsername(username);
		if(entriesEO==null)
			entriesEO=new OrderLogEntriesEO();
		entriesEO.setUsername(username);
		/*
		 * if(entriesEO.getOrder()!=null)
		 * totalNoOrderPresent=entriesEO.getOrder().compute(chkProduct,(key,val)->val+1)
		 * ; if(totalNoOrderPresent==null) { entriesEO.setOrder(new HashMap<ProductEO,
		 * Integer>()); entriesEO.getOrder().put(chkProduct, 1); }
		 */
		if(null!=entriesEO.getOrderEOs() &&  entriesEO.getOrderEOs().contains(chkOrderEO)) {
			orderEO=entriesEO.getOrderEOs().get(entriesEO.getOrderEOs().indexOf(chkOrderEO));
			int tmpTotal=orderEO.getTotalNumber();
			orderEO.setTotalNumber(tmpTotal+1);
		}else {
			if(null==entriesEO.getOrderEOs()) {
				orderEOs=new LinkedList<OrderEO>();
			entriesEO.setOrderEOs(orderEOs);
			}
			orderEO=new OrderEO();
			orderEO.setTotalNumber(1);
			orderEO.setProductEO(chkProduct);
			
			entriesEO.getOrderEOs().add(orderEO);
		}
		int tmpTotal=chkProduct.getTotalNumberOfProduct();
		chkProduct.setTotalNumberOfProduct(tmpTotal-1);
		if(chkProduct.getReOrder()>=chkProduct.getTotalNumberOfProduct() && !chkProduct.isStopOrder()) {
			log.info("Notify manager to reorder");
		}
		entriesEO.setDate(new Date());
		//entriesEO.setTimestamp(new java.security.Timestamp(entriesEO.getDate(), arg1));
		orderRepository.save(entriesEO);
	}
	
	public OrderLogEntriesEO getOrder(String username) {
		return orderRepository.findByUsername(username);
		
	}
}
