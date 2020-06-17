package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginSevlet
 */
@WebServlet("/LoginSevlet")
public class LoginSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").include(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String u = getServletContext().getInitParameter("username");
			String p = getServletContext().getInitParameter("password");
			
			if (username != null && username.equals(u) && password.equals(p)) {
				response.sendRedirect("home.jsp");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				response.getWriter().println("<font color='red'>Username or password is invalid</font>");
				rd.include(request, response);
			}
		} catch(Exception ex) {
			response.getWriter().println(ex);
		}
	}

}
