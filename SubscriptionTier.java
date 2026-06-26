package NetPlus;
import java.time.LocalDate;

public class SubscriptionTier {
private int id;
private Subscription subscription;
private String tierName;
private double monthlyPrice;
private double annualPrice;

public SubscriptionTier(int id, String tierName, double monthlyPrice, double annualPrice) {

	this.id = id;
	this.tierName = tierName;
	this.monthlyPrice = monthlyPrice;
	this.annualPrice = annualPrice;
}


public double calculatePrice (String billingCycle) {
	if(billingCycle == null) {return 0.0;}
	else if (billingCycle.equalsIgnoreCase("monthly")) {return this.monthlyPrice;}
	else if (billingCycle.equalsIgnoreCase("annual")) {return this.annualPrice;}
	else {System.out.println("ERROR"); return 0.0;}
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public Subscription getSubscription() {
	return subscription;
}


public void setSubscription(Subscription subscription) {
	this.subscription = subscription;
}


public String getTierName() {
	return tierName;
}


public void setTierName(String tierName) {
	this.tierName = tierName;
}


public double getMonthlyPrice() {
	return monthlyPrice;
}


public void setMonthlyPrice(double monthlyPrice) {
	this.monthlyPrice = monthlyPrice;
}


public double getAnnualPrice() {
	return annualPrice;
}


public void setAnnualPrice(double annualPrice) {
	this.annualPrice = annualPrice;
}















}
