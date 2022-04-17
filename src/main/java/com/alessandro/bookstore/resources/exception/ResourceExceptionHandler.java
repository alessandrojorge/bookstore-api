package com.alessandro.bookstore.resources.exception;

import javax.servlet.ServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alessandro.bookstore.service.exceptions.DateIntegrityViolationException;
import com.alessandro.bookstore.service.exceptions.ObjectnotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectnotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectnotFoundException e , ServletRequest resquest){
		
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	@ExceptionHandler(DateIntegrityViolationException.class)
	public ResponseEntity<StandardError> dateIntegrityViolationException(DateIntegrityViolationException e , ServletRequest resquest){
		
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}

}
