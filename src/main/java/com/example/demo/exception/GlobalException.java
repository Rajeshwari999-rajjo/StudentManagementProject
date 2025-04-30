package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(exception = StudentServiceException.class)
	public ResponseEntity handleStudentServiceException(StudentServiceException sse)
	{
		return new ResponseEntity(sse.getMessage(), sse.getHttpStstus());
	}
	
	@ExceptionHandler(exception = Exception.class)
	public ResponseEntity Exception(Exception e)
	{
		return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
