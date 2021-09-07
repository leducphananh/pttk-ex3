package vn.ptit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.ptit.dao.UserDAO;
import vn.ptit.model.User;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserDAO userDAO = new UserDAO();
		User user = userDAO.getUser(username, password);
		if (user == null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			req.setAttribute("status", "Đăng nhập thất bại");
			requestDispatcher.forward(req, resp);
		}
		else {
			Cookie cookie = new Cookie("email", user.getEmail());
			// setMaxAge: thời gian tồn tại của cookie (theo ms)
			// -1: mãi mãi, đến khi trình duyết tắt hoặc xóa cookie
			cookie.setMaxAge(-1);
			resp.addCookie(cookie);
			resp.sendRedirect("/pttk-ex3/");
		}
	}
}
