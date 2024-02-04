package com.bookstore.api.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.api.project.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	public List<Book> findAll();
	
	public Book findByBookId(Integer bookId);

}
