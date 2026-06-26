package NetPlus;
import java.time.LocalDate;

public class Subscription {
private int id;
private Customer customer;
private LocalDate startDate;
private LocalDate nextRenewalDate;
private String billingCycle;
private String subscriptionStatus;

public Subscription(int id,LocalDate startDate, LocalDate nextRenewalDate, String billingCycle, String subscriptionStatus) {

	this.id = id;
	this.startDate = startDate;
	this.nextRenewalDate = nextRenewalDate;
	this.billingCycle = billingCycle;
	this.subscriptionStatus = subscriptionStatus;
}
public Subscription(int id, String billingCycle, String subscriptionStatus) {

	this.id = id;
	this.billingCycle = billingCycle;
	this.subscriptionStatus = subscriptionStatus;
}
public boolean isDone() {
	LocalDate today = LocalDate.now();
	if(nextRenewalDate.isBefore(today))
		return true;
	else return false;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public LocalDate getStartDate() {
	return startDate;
}
public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
}
public LocalDate getNextRenewalDate() {
	return nextRenewalDate;
}
public void setNextRenewalDate(LocalDate nextRenewalDate) {
	this.nextRenewalDate = nextRenewalDate;
}
public String getBillingCycle() {
	return billingCycle;
}
public void setBillingCycle(String billingCycle) {
	this.billingCycle = billingCycle;
}
public String getSubscriptionStatus() {
	return subscriptionStatus;
}
public void setSubscriptionStatus(String subscriptionStatus) {
	this.subscriptionStatus = subscriptionStatus;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}




















}
