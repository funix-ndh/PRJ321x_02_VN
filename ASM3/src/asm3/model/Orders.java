package asm3.model;

import java.time.LocalDate;
import java.util.List;

public class Orders {
	private Integer orderId;
	private Double price;
	private Integer status;
	private LocalDate orderDatel;
	private String address;
	private String phoneNumber;
	private List<ProductOrders> lp;
	private String userMail;
	private LocalDate receiveDate;
	private String discount;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDate getOrderDatel() {
		return orderDatel;
	}
	public void setOrderDatel(LocalDate orderDatel) {
		this.orderDatel = orderDatel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<ProductOrders> getLp() {
		return lp;
	}
	public void setLp(List<ProductOrders> lp) {
		this.lp = lp;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public LocalDate getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(LocalDate receiveDate) {
		this.receiveDate = receiveDate;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
}
