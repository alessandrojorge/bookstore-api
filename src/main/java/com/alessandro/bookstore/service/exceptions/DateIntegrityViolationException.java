package com.alessandro.bookstore.service.exceptions;

public class DateIntegrityViolationException extends RuntimeException{

	private static final long serialVersionUID = 1L; //por que disso?

	
	public DateIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DateIntegrityViolationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
