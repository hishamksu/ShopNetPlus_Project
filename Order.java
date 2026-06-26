package NetPlus;
import java.time.LocalDate;


public class Order {
private int id;
private LocalDate orderDate;
private double totalOrderValue;
private double appliedCashback;
private String deliveryPriority;


public Order(int id, LocalDate orderDate, double totalOrderValue, double appliedCashback, String deliveryPriority) {
	
	this.id = id;
	this.orderDate = orderDate;
	this.totalOrderValue = totalOrderValue;
	this.appliedCashback = appliedCashback;
	this.deliveryPriority = deliveryPriority;
}


public Order(int id, double totalOrderValue, double appliedCashback, String deliveryPriority) {
	
	this.id = id;
	this.totalOrderValue = totalOrderValue;
	this.appliedCashback = appliedCashback;
	this.deliveryPriority = deliveryPriority;
}

public double calculateTotalPrice() {
	double a = this.totalOrderValue - this.appliedCashback;
	return a;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public LocalDate getOrderDate() {
	return orderDate;
}


public void setOrderDate(LocalDate orderDate) {
	this.orderDate = orderDate;
}


public double getTotalOrderValue() {
	return totalOrderValue;
}


public void setTotalOrderValue(double totalOrderValue) {
	this.totalOrderValue = totalOrderValue;
}


public double getAppliedCashback() {
	return appliedCashback;
}


public void setAppliedCashback(double appliedCashback) {
	this.appliedCashback = appliedCashback;
}


public String getDeliveryPriority() {
	return deliveryPriority;
}


public void setDeliveryPriority(String deliveryPriority) {
	this.deliveryPriority = deliveryPriority;
}











}
