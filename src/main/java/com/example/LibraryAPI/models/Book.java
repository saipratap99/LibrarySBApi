package com.example.LibraryAPI.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "book_name", nullable = false)
	private String bookName;
	
	@Column(name = "author_name", nullable = false)
	private String authorName;
	
	@Column(nullable = false)
	private String publisher;
	
	@Column(name = "published_on", nullable = false)
	private Date publishedOn;
	
	@Column(nullable = false, columnDefinition = "Decimal(10,2) default '0.0'")
	private double price;
	
	@Column(name = "picture_url")
	private String pictureUrl;
	
	@Column(name="total_stock", nullable = false, columnDefinition = "Integer default '0'")
	private int totalStock;
	
	@Column(name="available_stock", nullable = false, columnDefinition = "Integer default '0'")
	private int availableStock;
	
	@OneToMany(mappedBy = "book")
	List<BookTransaction> transactions;
	
	public List<BookTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<BookTransaction> transactions) {
		this.transactions = transactions;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishedOn() {
		return publishedOn;
	}

	public void setPublishedOn(Date publishedOn) {
		this.publishedOn = publishedOn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public int getTotalStock() {
		return totalStock;
	}

	public void setTotalStock(int totalStock) {
		this.totalStock = totalStock;
	}

	public int getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(int availableStock) {
		this.availableStock = availableStock;
	}
	
}
