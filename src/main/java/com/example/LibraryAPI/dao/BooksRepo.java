package com.example.LibraryAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibraryAPI.models.Book;

@Repository
public interface BooksRepo extends JpaRepository<Book, Long>{
}
