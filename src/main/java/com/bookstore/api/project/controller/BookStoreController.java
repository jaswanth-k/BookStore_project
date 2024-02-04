package com.bookstore.api.project.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.api.project.entity.Book;
import com.bookstore.api.project.exception.BookNotFoundException;
import com.bookstore.api.project.repository.BookRepository;

@RestController
@RequestMapping("api/bookstore/v1/books")
public class BookStoreController {
	
	@Autowired
	BookRepository bookRepo;
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks(){
		
		List<Book> booksList = bookRepo.findAll();
		
		return new ResponseEntity<>(booksList, HttpStatus.OK);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") Integer bookId){
		
		Book booksList = bookRepo.findByBookId(bookId);
		
		if(booksList == null) {
			throw new BookNotFoundException("Book not found with the Id: " + bookId );
		}
		
		return new ResponseEntity<>(booksList, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Book> addNewBooks(@RequestBody Book newBook){
		
		Book addedBook = bookRepo.save(newBook);
		
		return new ResponseEntity<>(addedBook, HttpStatus.OK);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") Integer bookId, @RequestBody Book newBook){
		
		Book booksList = bookRepo.findByBookId(bookId);
		if(booksList == null) {
			throw new BookNotFoundException("Update failed as book not found with the Id: " + bookId );
		}
		
		Book addedBook = bookRepo.save(newBook);
		
		return new ResponseEntity<>(addedBook, HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<Integer> deleteBook(@PathVariable("id") Integer bookId){
		
		Book booksList = bookRepo.findByBookId(bookId);
		if(booksList == null) {
			throw new BookNotFoundException("Delete failed as book not found with the Id: " + bookId );
		}
		
		bookRepo.deleteById(bookId);
		
		return new ResponseEntity<>(bookId, HttpStatus.OK);
		
	}
	
	
	

}
