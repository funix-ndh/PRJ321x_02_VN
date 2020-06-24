package asm3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import asm3.context.DBContext;
import asm3.model.Cart;
import asm3.model.Orders;
import asm3.model.Product;

public class OrdersDao {
	public void insertOrders(Cart cart, Orders orders) throws ClassNotFoundException, SQLException {
		try (Connection conn = DBContext.getConnection()) {
			conn.setAutoCommit(false);
			Integer orderId = null;
			try (PreparedStatement st = conn.prepareStatement("insert into orders(user_mail, order_discount_code, order_address) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
				st.setString(1, orders.getUserMail());
				st.setString(2, orders.getDiscount());
				st.setString(3, orders.getAddress());
				st.execute();
				try (ResultSet rs = st.getGeneratedKeys()) {
					if (rs != null && rs.next()) {
						orderId = rs.getInt(1);
					}
				}
			}
			for (Product product : cart.getItems()) {
				try (PreparedStatement st = conn.prepareStatement("insert into orders_detail(order_id, product_id, amount_product, price_product) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
					st.setInt(1, orderId);
					st.setInt(2, product.getId());
					st.setInt(3, product.getNumber());
					st.setDouble(4, product.getPrice());
					st.execute();
				}
			}
			conn.commit();
		}
	}
}
