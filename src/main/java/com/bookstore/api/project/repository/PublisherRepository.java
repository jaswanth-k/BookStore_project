package com.bookstore.api.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.api.project.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
	
	public List<Publisher> findAll();
	
	public Optional<Publisher> findByPublisherId(Integer id);

}
