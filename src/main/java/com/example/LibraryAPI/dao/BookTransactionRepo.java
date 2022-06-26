package com.example.LibraryAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibraryAPI.models.BookTransaction;

@Repository
public interface BookTransactionRepo extends JpaRepository<BookTransaction, Long> {
}
