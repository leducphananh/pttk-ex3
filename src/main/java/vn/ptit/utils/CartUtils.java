package vn.ptit.utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vn.ptit.model.book.BookItem;
import vn.ptit.model.order.Cart;
import vn.ptit.model.order.Payment;

public class CartUtils {
	
	public static void checkCart(BookItem bookItem, HttpServletRequest req) {
		int bookItemId = bookItem.getId();
		List<Cart> carts = new ArrayList<Cart>();
		HttpSession session = req.getSession();
		if(session.getAttribute("giohang") != null) {
			carts = (List<Cart>) session.getAttribute("giohang");
		}
		
		boolean isExist = false;
		for(Cart cart : carts) {
			if(cart.getBookItem().getId() == bookItemId) {
				isExist = true;
				cart.setQuantity(cart.getQuantity() + 1);
				break;
			}
		}
		
		if(!isExist) {
			Cart cart = new Cart();
			cart.setBookItem(bookItem);
			cart.setQuantity(1);
			carts.add(cart);
		}
		
		int soluongmua = 0;
		for(Cart cart : carts) {
			soluongmua += cart.getQuantity();
		}
		
		session.setAttribute("status", null);
		session.setAttribute("giohang", carts);
		session.setAttribute("soluongmua", soluongmua);
	}
	
	public static void tongTien(HttpServletRequest req) {
		List<Cart> carts = new ArrayList<Cart>();
		HttpSession session = req.getSession();
		if(session.getAttribute("giohang") != null) {
			carts = (List<Cart>) session.getAttribute("giohang");
		}
		double tongTien = 0;
		for(Cart cart : carts) {
			tongTien += cart.getBookItem().getPrice() * cart.getQuantity();
		}
		session.setAttribute("tongTien", tongTien);
	}
	
	public static void tongTienTatCa(HttpServletRequest request) {
		List<Cart> carts = new ArrayList<>();
		HttpSession httpSession = request.getSession();
		Payment payment = new Payment();
		if (httpSession.getAttribute("payment") != null) {
			payment = (Payment) httpSession.getAttribute("payment");
		}
		carts = payment.getCarts();
		double tongTien = 0;
		for(Cart cart : carts) {
			tongTien += cart.getBookItem().getPrice() * cart.getQuantity();
		}

		tongTien += payment.getShipment().getPrice();

		httpSession.setAttribute("tongTienTatCa", tongTien);
	}
}
