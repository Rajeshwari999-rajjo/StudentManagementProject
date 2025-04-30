package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class StudentServiceException extends RuntimeException{
	
	private String exMessage;
	private HttpStatus httpStstus;

	@Override
	public String getMessage() {
		return exMessage;
	}

	public HttpStatus getHttpStstus() {
		return httpStstus;
	}

	public StudentServiceException(String exMessage, HttpStatus httpStstus) {
		this.exMessage = exMessage;
		this.httpStstus = httpStstus;
	}

	
	

}
