package asm3.dao;

import asm3.context.DBContext;
import asm3.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ListProductDAO {
	public Product getById(Integer id) throws ClassNotFoundException, SQLException {
		try(Connection conn = DBContext.getConnection()) {
			try (PreparedStatement st = conn.prepareStatement("select * from products where product_id = ?")) {
				st.setInt(1, id);
				try (ResultSet rs = st.executeQuery()) {
					Product product = null;
					if (rs != null && rs.next()) {
						product = getProduct(rs);
					}
					return product;	
				}
			}
		}	
	}
	
	public List<Product> search(String name) throws ClassNotFoundException, SQLException {
		try (Connection conn = DBContext.getConnection();) {
			try (PreparedStatement st = conn.prepareStatement("select * from products where product_name like ?")) {
				st.setString(1, "%"+name+"%");
				try (ResultSet rs = st.executeQuery()) {
					List<Product> products = new ArrayList<>();
					while (rs != null && rs.next()) {
						products.add(getProduct(rs));
					}
					return products;	
				}
			}
		}
	}

	private static Product getProduct(ResultSet rs) throws SQLException {
		Product product = new Product();
		product.setId(Integer.valueOf(rs.getString("product_id")));
		product.setName(rs.getString("product_name"));
		product.setDescription(rs.getString("product_des"));
		product.setPrice(Double.valueOf(rs.getString("product_price")));
		product.setSrc(rs.getString("product_img_source"));
		product.setType(rs.getString("product_type"));
		product.setBrand(rs.getString("product_brand"));
		return product;
	}
}
