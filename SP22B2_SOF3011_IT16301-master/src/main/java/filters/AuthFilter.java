package filters;

import java.io.IOException;

import javax.jms.Session;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entites.User;

@WebFilter("/admin/*")
public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request,
			ServletResponse response,
			FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq= (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		HttpSession session = httpReq.getSession();
//		session.invalidate();
		User u = (User) session.getAttribute("user");
		if (u == null) {
			httpRes.sendRedirect("/SP22B2_SOF3011_IT16301/login");
			return;
		}
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		
		
		
	}

}
