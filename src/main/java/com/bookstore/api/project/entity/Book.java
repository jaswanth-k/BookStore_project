package com.bookstore.api.project.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "BOOK_ID")
	private Integer bookId;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "AUTHOR")
	private String author;
	
	@Column(name = "PAGES")
	private Integer pages;

	@Column(name = "EDITION")
	private String edition;
	
	@Column(name = "RELEASE_DATE")
	private Date releaseDate;
	
	@Column(name = "NO_OF_COPIES_AVAIL")
	private Integer noOfCopiesAvailable;
	
	@OneToOne(targetEntity = Publisher.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "PUBLISHER_ID")
	private Publisher publisher;

	public Book() {
		
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getNoOfCopiesAvailable() {
		return noOfCopiesAvailable;
	}

	public void setNoOfCopiesAvailable(Integer noOfCopiesAvailable) {
		this.noOfCopiesAvailable = noOfCopiesAvailable;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", pages=" + pages + ", edition="
				+ edition + ", releaseDate=" + releaseDate + ", noOfCopiesAvailable=" + noOfCopiesAvailable
				+ ", publisher=" + publisher + "]";
	}

	
	
}
