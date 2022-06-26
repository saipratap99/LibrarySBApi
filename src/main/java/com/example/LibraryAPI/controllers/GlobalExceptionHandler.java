package com.example.LibraryAPI.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.LibraryAPI.exceptions.BookNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	public String getJSONString(String key, String value) {
		return "\""+ key + "\"" + ":" + "\"" + value + "\"";
	}
	
	@ExceptionHandler(value = BookNotFoundException.class)
	public ResponseEntity<String> bookNotFoundException(BookNotFoundException e){
		return new ResponseEntity<String>("{" + getJSONString("msg", e.getMessage()) + "}", HttpStatus.BAD_REQUEST);
	}
	
	
}
