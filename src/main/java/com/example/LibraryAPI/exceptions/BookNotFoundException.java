package com.example.LibraryAPI.exceptions;

public class BookNotFoundException extends Exception{
	public BookNotFoundException(String message) {
		super(message);
	}
}
