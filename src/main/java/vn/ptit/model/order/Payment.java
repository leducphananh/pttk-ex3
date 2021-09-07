package vn.ptit.model.order;

import java.util.List;

public class Payment {
	private int id;
	private String paymentType;
	private List<Cart> carts;
	private Shipment shipment;
	
	public Payment() {
		super();
	}

	public Payment(int id, String paymentType, List<Cart> carts, Shipment shipment) {
		super();
		this.id = id;
		this.paymentType = paymentType;
		this.carts = carts;
		this.shipment = shipment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
}
