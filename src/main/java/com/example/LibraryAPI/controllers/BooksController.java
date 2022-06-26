package com.example.LibraryAPI.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryAPI.dao.BooksRepo;
import com.example.LibraryAPI.exceptions.BookNotFoundException;
import com.example.LibraryAPI.models.Book;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {
	
	@Autowired
	BooksRepo booksRepo;
	
	@PostMapping("/create")
	public Book createBook(@RequestBody Book book) {
		return booksRepo.save(book);
	}
	
	@GetMapping("/{id}")
	public Book getBook(@PathVariable long id) throws BookNotFoundException {
		Optional<Book> bookOptional = booksRepo.findById(id);
		bookOptional.orElseThrow(() -> new BookNotFoundException("Book not found with Id: " + id));
		
		return bookOptional.get(); 
	}
	
	@PutMapping("/{id}")
	public Book updateBook(@PathVariable long id, @RequestBody Book book) throws BookNotFoundException {
		
		Optional<Book> bookOptional = booksRepo.findById(id);
		bookOptional.orElseThrow(() -> new BookNotFoundException("Book not found with Id: " + id));		
		
		book.setId(id);
		book = booksRepo.save(book);
		return book;

	}
	
	@DeleteMapping("/{id}")
	public Book deleteBook(@PathVariable long id) throws BookNotFoundException {
		Optional<Book> bookOptional = booksRepo.findById(id);
		bookOptional.orElseThrow(() -> new BookNotFoundException("Book not found with Id: " + id));
		
		booksRepo.delete(bookOptional.get());
		return bookOptional.get();	
	}
}
