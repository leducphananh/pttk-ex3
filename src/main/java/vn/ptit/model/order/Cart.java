package vn.ptit.model.order;

import vn.ptit.model.book.BookItem;

public class Cart {
	private int id;
	private int quantity;
	private BookItem bookItem;
	public Cart() {
		super();
	}
	public Cart(int id, int quantity, BookItem bookItem) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.bookItem = bookItem;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BookItem getBookItem() {
		return bookItem;
	}
	public void setBookItem(BookItem bookItem) {
		this.bookItem = bookItem;
	}
	
	
}
