package com.fsd.inventory.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fsd.ExceptionService.BusinessValidationException;
import com.fsd.ExceptionService.CustomErrorResponse;

@ControllerAdvice
public class RestExceptionController extends ResponseEntityExceptionHandler {
	 @ExceptionHandler(value = BusinessValidationException.class)
	   public ResponseEntity<CustomErrorResponse> exception(BusinessValidationException exception) {
	    CustomErrorResponse customErrorResponse=new CustomErrorResponse();
	    customErrorResponse.setTimestamp(LocalDateTime.now());
	    customErrorResponse.setMessage(exception.getMessage());
	    customErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		 return new ResponseEntity(customErrorResponse, HttpStatus.BAD_REQUEST);
	   }
}
