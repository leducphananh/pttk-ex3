package vn.ptit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.ptit.dao.UserDAO;
import vn.ptit.model.User;

@WebFilter(urlPatterns = {"/checkout", "/finish"})
public class CheckLogin implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		Cookie cookies[] = req.getCookies();
		String email = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equalsIgnoreCase("email")) {
				email = cookie.getValue();
				break;
			}
		}

		if (email != null){
			UserDAO userDAO = new UserDAO();
			User user = userDAO.getUserByEmail(email);
			req.getSession().setAttribute("email", user.getEmail());
			chain.doFilter(request, response);
		}
		else
			resp.sendRedirect("/pttk-ex3/login");

	}
}