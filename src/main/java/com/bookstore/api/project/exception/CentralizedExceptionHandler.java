package com.bookstore.api.project.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CentralizedExceptionHandler {

	@ExceptionHandler({BookNotFoundException.class,PublisherNotFoundException.class})
	public ResponseEntity<CustomErrorResponse> handleCustomException(Exception e){
		CustomErrorResponse errorResp = new CustomErrorResponse();
		errorResp.setMessage(e.getMessage());
		errorResp.setStatus(HttpStatus.NOT_FOUND.value());
		errorResp.setTimeStamp(new Date());
		
		return new ResponseEntity<>(errorResp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleGenericException(Exception e){
		CustomErrorResponse errorResp = new CustomErrorResponse();
		errorResp.setMessage(e.getMessage());
		errorResp.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResp.setTimeStamp(new Date());
		
		return new ResponseEntity<>(errorResp, HttpStatus.BAD_REQUEST);
	}
	
}
