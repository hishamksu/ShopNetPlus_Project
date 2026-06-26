package NetPlus;
import java.time.LocalDate;

public class Controller {
private CustomerDAO CustomerDAO;
private SubscriptionDAO SubscriptionDAO;
private PaymentDAO PaymentDAO;



public Controller() {
	
	this.CustomerDAO = new CustomerDAO();
	this.SubscriptionDAO = new SubscriptionDAO();
	this.PaymentDAO = new PaymentDAO();
}



public void processNewSubscription(Customer customer, SubscriptionTier tier, String billingCycle) {
	if(customer.hasActiveSubscription()) {
		System.out.println("ERROR, YOU HAVE IT ALREADY");
		return;
	}
	
	double price = tier.calculatePrice(billingCycle);
	
	boolean isPay = PaymentDAO.processPaymentTransaction(customer.getId(), price, "Credit Card", "Completed");
	
	if(!isPay) {System.out.println("ERROR, PAYMENT FAILED!"); return;}
	
	SubscriptionDAO.insertSubscription(customer.getId(),tier.getId(), billingCycle, "Active");
	System.out.println("Added Successfully!");
	
};

































}
