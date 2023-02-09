package controllers;
import dao.UserDAO;
import entites.User;
import utils.EncryptUtil;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private UserDAO userDAO;

	public LoginServlet() {
		this.userDAO = new UserDAO();
	}
	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		request.getRequestDispatcher("/views/login.jsp")
			.forward(request, response);
	}
	
	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) {
		String email = request.getParameter("email"),
			pwd = request.getParameter("password");

		User u = this.userDAO.findByEmail(email);
		boolean check = EncryptUtil.check(pwd, u.getPassword());
		HttpSession session = request.getSession();
		if (check == true) {
			// Đăng nhập thành công
			session.setAttribute("user", u);
		} else {
			// Đăng nhập thất bại
		}
	}
}
