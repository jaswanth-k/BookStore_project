package com.bookstore.api.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.api.project.entity.Book;
import com.bookstore.api.project.entity.UsersTable;

@Repository
public interface UserRepository extends JpaRepository<UsersTable, String> {
	
	List<UsersTable> findByUserName(String userName);

}
