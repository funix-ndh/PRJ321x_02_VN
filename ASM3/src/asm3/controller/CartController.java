package asm3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asm3.dao.ListProductDAO;
import asm3.dao.OrdersDao;
import asm3.model.Cart;
import asm3.model.Orders;
import asm3.model.Product;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ListProductDAO listProductDAO;
	private OrdersDao ordersDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        listProductDAO = new ListProductDAO();
        ordersDao = new OrdersDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("cart.jsp").include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String action = request.getParameter("action");
			if (action == null) {
				return;
			}
			HttpSession session = request.getSession(true);
			Cart cart = (Cart)session.getAttribute("cart");
			if (cart == null) {
				cart = new Cart();
			}
			String productId = request.getParameter("id");
			if (productId != null && action.equals("add")) {
				Product p = listProductDAO.getById(Integer.valueOf(productId));
				cart.add(p);
				session.setAttribute("cart", cart);
				response.sendRedirect("/ASM3/cart");
			} else if (productId != null && action.equals("remove")) {
				Product p = listProductDAO.getById(Integer.valueOf(productId));
				cart.remove(p);
				session.setAttribute("cart", cart);
				response.sendRedirect("/ASM3/cart");
			} else if (action.equals("checkout")) {
				Orders orders = new Orders();
				orders.setUserMail(request.getParameter("email"));
				orders.setAddress(request.getParameter("address"));
				orders.setDiscount(request.getParameter("discount"));
				ordersDao.insertOrders(cart, orders);
				session.removeAttribute("cart");;
				response.sendRedirect("/ASM3/home");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
