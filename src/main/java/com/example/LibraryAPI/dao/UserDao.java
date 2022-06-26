package com.example.LibraryAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibraryAPI.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
	
}
