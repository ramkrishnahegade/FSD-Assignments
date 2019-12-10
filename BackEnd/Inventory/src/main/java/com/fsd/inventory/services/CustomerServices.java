package com.fsd.inventory.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.ExceptionService.BusinessValidationException;
import com.fsd.inventory.EO.CustomerEO;
import com.fsd.inventory.repository.CustomerRepository;

@Service
public class CustomerServices {

	private static Logger log = LoggerFactory.getLogger(CustomerServices.class);
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public void addCustomer(CustomerEO customerEO) throws BusinessValidationException {
		if(findCustomerbyUsername(customerEO.getUsername())==null)
			customerRepository.insert(customerEO);
		else
			throw new BusinessValidationException("UserName is not availaible");
		
	}
	
	
	public CustomerEO findCustomerbyUsernameandPwd(String username , String pwd) {
	 return customerRepository.findByUsernameAndPassword(username, pwd)	;
	}
	public CustomerEO findCustomerbyUsername(String username ) {
		return customerRepository.findByUsername(username);
	}
	
}
