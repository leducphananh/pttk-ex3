package vn.ptit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.ptit.dao.OrderDAO;
import vn.ptit.dao.UserDAO;
import vn.ptit.model.User;
import vn.ptit.model.order.Order;
import vn.ptit.model.order.Payment;
import vn.ptit.utils.CartUtils;

@WebServlet(urlPatterns = "/finish")
public class FinishController extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		OrderDAO orderDAO = new OrderDAO();
		HttpSession httpSession = req.getSession();
		Payment payment = new Payment();
		String email = httpSession.getAttribute("email").toString();
		if(httpSession.getAttribute("payment")!=null) {
			payment =  (Payment) httpSession.getAttribute("payment");
		}
		User user = userDAO.getUserByEmail(email);
		Order order = new Order();
		order.setPayment(payment);
		order.setUser(user);
		
		boolean check = orderDAO.insertOrder(order);
		if(check) {
			httpSession.setAttribute("payment", null);
			httpSession.setAttribute("giohang", null);
			httpSession.setAttribute("soluongmua", null);
		
			resp.sendRedirect("/pttk-ex3/");
		}
		else {
			req.setAttribute("status", "failed");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("checkout.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
	
}
