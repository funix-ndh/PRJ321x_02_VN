package asm3.model;

public class ProductOrders {
	private Integer orderId;
	private Integer productId;
	private Integer amountProduct;
	private String nameProduct;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getAmountProduct() {
		return amountProduct;
	}
	public void setAmountProduct(Integer amountProduct) {
		this.amountProduct = amountProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
}
