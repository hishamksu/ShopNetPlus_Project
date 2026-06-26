package NetPlus;
import java.time.LocalDate;

public class Payment {
private double transactionAmount;
private LocalDate paymentDate;
private String PaymentMethod;
private String transactionStatus;
public Payment(double transactionAmount, LocalDate paymentDate, String paymentMethod, String transactionStatus) {
	super();
	this.transactionAmount = transactionAmount;
	this.paymentDate = paymentDate;
	PaymentMethod = paymentMethod;
	this.transactionStatus = transactionStatus;
}
public Payment(double transactionAmount, String paymentMethod, String transactionStatus) {
	super();
	this.transactionAmount = transactionAmount;
	PaymentMethod = paymentMethod;
	this.transactionStatus = transactionStatus;
}
public double getTransactionAmount() {
	return transactionAmount;
}
public void setTransactionAmount(double transactionAmount) {
	this.transactionAmount = transactionAmount;
}
public LocalDate getPaymentDate() {
	return paymentDate;
}
public void setPaymentDate(LocalDate paymentDate) {
	this.paymentDate = paymentDate;
}
public String getPaymentMethod() {
	return PaymentMethod;
}
public void setPaymentMethod(String paymentMethod) {
	PaymentMethod = paymentMethod;
}
public String getTransactionStatus() {
	return transactionStatus;
}
public void setTransactionStatus(String transactionStatus) {
	this.transactionStatus = transactionStatus;
}



}
