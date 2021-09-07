package vn.ptit.model.book;

public class BookItem {
	private int id;
	private Book book;
	private double price;
	private int quantity;
	public BookItem() {
		super();
	}
	
	public BookItem(int id, Book book, double price, int quantity) {
		super();
		this.id = id;
		this.book = book;
		this.price = price;
		this.quantity = quantity;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
