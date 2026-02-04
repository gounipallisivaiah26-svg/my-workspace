package com.easyLearing.controllerAdvice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.easyLearing.exception.userNotFoundException;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgumet(MethodArgumentNotValidException ex) {
	    Map<String, String> errorMap = new HashMap<>();
	    ex.getBindingResult().getFieldErrors().forEach((error) -> {
	    	errorMap.put(error.getField(), error.getDefaultMessage());
	    });
	    return errorMap;
	    //check all validations for field s and methods
	}
	
	@ResponseStatus(HttpStatus.	INTERNAL_SERVER_ERROR)
	@ExceptionHandler(userNotFoundException.class)
	public Map<String, String> handleBusinessException(userNotFoundException ex) {
	    Map<String, String> errorMap = new HashMap<>();
	   errorMap.put("errorMessage", ex.getMessage());
	    return errorMap;
	    //check all validations for field s and methods
	}
	
	
}
