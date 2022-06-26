package com.example.LibraryAPI.controllers;

import java.security.Principal;
import java.sql.Date;
import java.util.Calendar;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryAPI.dao.BookTransactionRepo;
import com.example.LibraryAPI.dao.BooksRepo;
import com.example.LibraryAPI.dao.UserDao;
import com.example.LibraryAPI.exceptions.BookNotFoundException;
import com.example.LibraryAPI.models.Book;
import com.example.LibraryAPI.models.BookTransaction;
import com.example.LibraryAPI.models.User;

@RestController
@RequestMapping("/api/v1/transactions")
public class BookTransactionController {

	
	@Autowired
	BooksRepo booksRepo;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	BookTransactionRepo bookTransactionRepo;
	
	
	@PostMapping("/borrow/book/{id}")
	public String borrowBook(@PathVariable long id, Principal principal) throws BookNotFoundException {
		Optional<Book> bookOptional = booksRepo.findById(id);
		bookOptional.orElseThrow(() -> new BookNotFoundException("Book not found with Id: " + id));
		
		long userId = 6;
		Optional<User> userOptional = userDao.findById(userId);
		
		BookTransaction bookTransaction = new BookTransaction();
		
		bookTransaction.setUser(userOptional.get());
		bookTransaction.setBook(bookOptional.get());
		bookTransaction.setBorrowedOn(new Date(System.currentTimeMillis()));
		bookTransaction.setDueDate(addDays(bookTransaction.getBorrowedOn(), bookTransaction.getDays()));

		bookTransactionRepo.save(bookTransaction);
		return "Book Transaction Done";		
	}
	
	public Date addDays(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
//		return new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
		return new Date(calendar.getTimeInMillis());
	}
}
