package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloServlet() {
        super();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String name = request.getParameter("ho_ten");
		request.setAttribute("name", name);
		request.getRequestDispatcher("/views/layout.jsp")
			.forward(request, response);
	}

	public void init() {
		System.out.println("Init Servlet ...");
	}
	
	protected void service(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		System.out.println("Service ...");
		super.service(request, response);
	}
	
	public void destroy() {
		System.out.println("Destroy...");
	}
}
