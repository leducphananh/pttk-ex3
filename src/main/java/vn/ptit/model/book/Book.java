package vn.ptit.model.book;

import java.util.Date;

public class Book {
	private int id;
	private String name;
	private String author;
	private Date datecreate;
	public Book() {
		super();
	}
	public Book(int id, String name, String author, Date datecreate) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.datecreate = datecreate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getDatecreate() {
		return datecreate;
	}
	public void setDatecreate(Date datecreate) {
		this.datecreate = datecreate;
	}
	
}
