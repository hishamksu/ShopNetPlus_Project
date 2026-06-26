package NetPlus;
import java.sql.*;
import java.time.LocalDate;

public class Customer extends User{
private String shippingAddress;
private LocalDate dateOfBirth;
private String notificationPrefernces;

private Subscription subscription;

public Customer(int id,String emailAddress,String passwordHash,LocalDate registerDate,String shippingAddress,LocalDate dateOfBirth, String notificationPrefernces) {
	super(id,emailAddress,passwordHash,registerDate);
	this.shippingAddress=shippingAddress;
	this.dateOfBirth=dateOfBirth;
	this.notificationPrefernces=notificationPrefernces;
}
public Customer(int id,String emailAddress,String passwordHash,String shippingAddress,LocalDate dateOfBirth, String notificationPrefernces) {
	super(id,emailAddress,passwordHash);
	this.shippingAddress=shippingAddress;
	this.dateOfBirth=dateOfBirth;
	this.notificationPrefernces=notificationPrefernces;
}

public boolean hasActiveSubscription() {
	if(this.subscription != null && this.subscription.getsubscriptionStatus.equalsIgnoreCase("Active"))
		return true;
	else return false;
}





public String getShippingAddress() {
	return shippingAddress;
}
public void setShippingAddress(String shippingAddress) {
	this.shippingAddress = shippingAddress;
}
public LocalDate getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String getNotificationPrefernces() {
	return notificationPrefernces;
}
public void setNotificationPrefernces(String notificationPrefernces) {
	this.notificationPrefernces = notificationPrefernces;
}
public Subscription getSubscription() {
	return subscription;
}
public void setSubscription(Subscription subscription) {
	this.subscription = subscription;
}







}
