package com.bookstore.api.project.controller;

import java.util.List;
import java.util.Optional;

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

import com.bookstore.api.project.entity.Publisher;
import com.bookstore.api.project.exception.PublisherNotFoundException;
import com.bookstore.api.project.repository.PublisherRepository;

@RestController
@RequestMapping("api/bookstore/v1/publishers")
public class BookStorePublisherController {
	
	@Autowired
	PublisherRepository pubRepo;
	
	@GetMapping
	public ResponseEntity<List<Publisher>> getAllPublishers(){
		
		List<Publisher> publishersList = pubRepo.findAll();
		
		return new ResponseEntity<>(publishersList, HttpStatus.OK);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Publisher> getublisher(@PathVariable("id") Integer publisherId){
		
		Optional<Publisher> publisher = pubRepo.findByPublisherId(publisherId);
		
		if(publisher.isPresent()) {
			return new ResponseEntity<>(publisher.get(), HttpStatus.OK);
			
		}
		
		throw new PublisherNotFoundException("Publisher not found with the Id: " + publisherId );
	}
	
	@PostMapping
	public ResponseEntity<Publisher> addNewPublishers(@RequestBody Publisher newPublisher){
		
		Publisher addedPublisher = pubRepo.save(newPublisher);
		
		return new ResponseEntity<>(addedPublisher, HttpStatus.OK);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Publisher> updatePublisher(@PathVariable("id") Integer publisherId, @RequestBody Publisher newPublisher){
		
		Optional<Publisher> publisher = pubRepo.findByPublisherId(publisherId);
		
		if(publisher.isPresent()) {
			
			Publisher addedPublisher = pubRepo.save(newPublisher);
			return new ResponseEntity<>(addedPublisher, HttpStatus.OK);
		}
		
		throw new PublisherNotFoundException("Update failed as publisher not found with the Id: " + publisherId );
		
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<Integer> deleteBook(@PathVariable("id") Integer publisherId){
		
		Optional<Publisher> publisher = pubRepo.findByPublisherId(publisherId);
		
		if(publisher.isPresent()) {
			pubRepo.deleteById(publisherId);
			return new ResponseEntity<>(publisherId, HttpStatus.OK);
		}
		
		throw new PublisherNotFoundException("Delete failed as publisher not found with the Id: " + publisherId );
		
	}
	
	
	

}
