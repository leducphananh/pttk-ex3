package vn.ptit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.ptit.utils.CartUtils;

@WebServlet(urlPatterns = "/checkout")
public class CheckoutController extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CartUtils.tongTienTatCa(req);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("checkout.jsp");
		requestDispatcher.forward(req, resp);
		
	}
	
}
