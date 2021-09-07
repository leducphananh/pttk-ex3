package vn.ptit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.ptit.dao.ShipmentDAO;
import vn.ptit.model.order.Cart;
import vn.ptit.model.order.Payment;
import vn.ptit.model.order.Shipment;

@WebServlet(urlPatterns =  "/cart")
public class CartController extends HttpServlet{
	
	private ShipmentDAO shipmentDAO;
	
	@Override
	public void init() throws ServletException {
		shipmentDAO = new ShipmentDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listShipment", shipmentDAO.getAllShipment());
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("cart.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String paymentType = req.getParameter("paymentType");
		int shipmentId = Integer.parseInt(req.getParameter("shipment"));
		List<Cart> carts = new ArrayList<>();
		HttpSession session = req.getSession();
		if (session.getAttribute("giohang") != null) {
			carts = (List<Cart>) session.getAttribute("giohang");
		}
		Payment payment = new Payment();
		payment.setCarts(carts);
		payment.setPaymentType(paymentType);
		payment.setShipment(shipmentDAO.findById(shipmentId));
		session.setAttribute("payment", payment);
		resp.sendRedirect("/pttk-ex3/checkout");
	}
	
}
