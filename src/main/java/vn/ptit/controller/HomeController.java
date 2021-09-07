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

import vn.ptit.dao.BookDAO;
import vn.ptit.model.book.Book;
import vn.ptit.model.book.BookItem;
import vn.ptit.utils.CartUtils;

@WebServlet(urlPatterns =  "/")
public class HomeController extends HttpServlet{
	
	private BookDAO bookDAO;
	
	@Override
	public void init() throws ServletException {
		bookDAO = new BookDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch(action) {
			case "/":
				listBookItem(req, resp);
				break;
			case "/addToCart":
				addToCart(req, resp);
				break;
		}
	}
	
	private void listBookItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		List<BookItem> listBookItem = bookDAO.getAllBookItem();
		req.setAttribute("listBookItem", listBookItem);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("list-book.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	private void addToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int id = Integer.parseInt(req.getParameter("id"));
		BookItem bookItem = bookDAO.getBookItemById(id);
		CartUtils.checkCart(bookItem, req);
		CartUtils.tongTien(req);
		resp.sendRedirect("/pttk-ex3/");
	}
}
