package asm3.controller;

import asm3.dao.ListProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import asm3.model.Product;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ListProductDAO listProductDAO;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        listProductDAO = new ListProductDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String search = request.getParameter("search");
			List<Product> products = listProductDAO.search(search == null ? "" : search);
			request.setAttribute("products", products);
			request.setAttribute("search", search);
			request.getRequestDispatcher("home.jsp").include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
