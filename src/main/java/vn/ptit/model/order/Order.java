package vn.ptit.model.order;

import vn.ptit.model.User;

public class Order {
	private int id;
	private Payment payment;
	private User user;
	
	public Order() {
		super();
	}

	public Order(int id, Payment payment, User user) {
		super();
		this.id = id;
		this.payment = payment;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
