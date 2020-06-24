package asm3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("login.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			String regexEmail = "^([a-zA-Z0-9_.\\-])+@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
			String regex = "[a-zA-Z0-9!@#$%^&*]+";

			if (!password.matches(regex) || !username.matches(regexEmail)) {
				request.setAttribute("error", "invalid syntax");
				request.getRequestDispatcher("login.jsp").include(request, response);
				return;
			}
			String u = getServletContext().getInitParameter("username");
			String p = getServletContext().getInitParameter("password");
			if (username != null && username.equals(u) && password.equals(p)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("admin/index.jsp");
			} else {
				request.setAttribute("error", "wrong username or password");
				request.getRequestDispatcher("login.jsp").include(request, response);
			}
		}
	 }

}
