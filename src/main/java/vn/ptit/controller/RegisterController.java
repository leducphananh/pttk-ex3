package vn.ptit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.ptit.dao.UserDAO;
import vn.ptit.model.User;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String country = req.getParameter("country");
		String email = req.getParameter("email");
		
		UserDAO userDAO = new UserDAO();
		
		List<User> list = userDAO.getAllUser();

		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			if (username.equalsIgnoreCase(list.get(i).getUsername())) {
				flag = true;
				break;
			}
		}
		
		if (flag) {
			req.setAttribute("status", "Tên đăng nhập bị trùng");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			User user = new User();
			user.setCountry(country);
			user.setEmail(email);
			user.setGender(gender);
			user.setUsername(username);
			user.setPassword(password);
			userDAO.insertUser(user);
			resp.sendRedirect("/pttk-ex3/login");	
		}

	}
	
}
