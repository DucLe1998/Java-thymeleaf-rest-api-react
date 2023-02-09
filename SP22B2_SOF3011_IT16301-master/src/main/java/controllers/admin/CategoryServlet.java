package controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.UserDAO;
import entites.Category;
import entites.User;

@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CategoryServlet() {
        super();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		List<User> dsUser = userDAO.all();
		
		request.setAttribute("ds", dsUser);
		request.getRequestDispatcher(
			"/views/admin/categories/create.jsp"
		).forward(request, response);
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		CategoryDAO cateDAO = new CategoryDAO();
		String ten = request.getParameter("ten");
		String userIdStr = request.getParameter("user_id");
		
		int userId = Integer.parseInt(userIdStr);
		User u = userDAO.findById(userId);
		
		Category c = new Category();
		c.setTen(ten);
		c.setUser(u);
		cateDAO.create(c);
	}

}
