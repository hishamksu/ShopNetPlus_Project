package src.src.NetPlus;
import java.util.Locale;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	
private static Customer cus = null;
private static CustomerDAO customerDAO = new CustomerDAO();
private static Controller controller = new Controller();
private static AdminDAO adminDAO = new AdminDAO();
private static SubscriptionDAO subscriptionDAO = new SubscriptionDAO();
private static Scanner input = new Scanner(System.in).useLocale(Locale.US);;

public static void main(String[] args) {
	Locale.setDefault(Locale.ENGLISH);
	boolean run = true;
	while (run) {
		System.out.println("Welcome to Net Plus shop");
		System.out.println("1- Log in");
		System.out.println("2- Register as a new customer");
		System.out.println("3- Exit");
		System.out.println("Please select :");
		int num = input.nextInt();

		if (num == 1) {
			System.out.println("Enter your email :");
			String email = input.next();
			System.out.println("Enter your password :");
			String pass = input.next();

			if (customerDAO.chekLogIn(email, pass)) {
				cus = customerDAO.getCustomerByCredentials(email, pass);
				customerMenu();
			}
			else if (adminDAO.chekLogIn(email, pass)) {
				adminMenu();
			}
			else {
				System.out.println("Invalid email or password.");
			}
		}
		else if (num == 2) {
			registerNewCustomer();
		}
		else if (num == 3) {
			System.out.println("Thanks...");
			run = false;
		}
		else {
			System.out.println("Invalid selection.");
		}
	}

	input.close();
}

private static void registerNewCustomer() {
	System.out.println("Enter your email :");
	String email = input.next();

	if (customerDAO.emailExists(email)) {
		System.out.println("This email is already registered. Please log in instead.");
		return;
	}

	System.out.println("Enter your password :");
	String pass = input.next();
	System.out.println("Enter your shipping address :");
	String shippingAddress = input.next();
	
	
	
	
	
	
	LocalDate dateOfBirth = null;
	while (dateOfBirth == null) {
	    System.out.println("Enter your date of birth (YYYY-MM-DD) :");
	    String dobInput = input.next();
	    try {
	        dateOfBirth = LocalDate.parse(dobInput);
	    } catch (Exception e) {
	        System.out.println("Invalid date format. Please use YYYY-MM-DD (example: 2000-05-20)");
	    }
	}
	
	
	
	//System.out.println("Enter your date of birth (YYYY-MM-DD) :");
	//LocalDate dateOfBirth = LocalDate.parse(input.next());
	
	
	
	
	
	System.out.println("Enter your notification preferences :");
	String notificationPreferences = input.next();

	int newId = customerDAO.getNextCustomerId();
	customerDAO.insertCustomer(newId, email, pass, shippingAddress, dateOfBirth, notificationPreferences);
}

private static void customerMenu() {
	boolean mc = true;
	while (mc) {
		System.out.println("\n1- Browse Membership Tiers");
		System.out.println("2- Subscribe to a new membership");
		System.out.println("3- Upgrade your membership");
		System.out.println("4- View my membership data");
		System.out.println("5- Log out");
		System.out.println("Please select :");
		int ch = input.nextInt();

		if (ch == 1) {
			subscriptionDAO.displayAllTiers();
		}
		else if (ch == 2) {
			System.out.println("Enter Tier id:");
			int tid = input.nextInt();
			System.out.println("Enter billing cycle Monthly/Annually:");
			String billingCycle = input.next();
			controller.processNewSubscription(cus, subscriptionDAO.getTierById(tid), billingCycle);
		}
		else if (ch == 3) {
			System.out.println("Enter new Tier id:");
			int newtid = input.nextInt();
			subscriptionDAO.updateSubscriptionTier(newtid, cus.getId());
		}
		else if (ch == 4) {try (ResultSet rs = customerDAO.getCustomerDashboardData(cus.getId())) {
	        if (rs != null && rs.next()) {
	            System.out.println("\n=== [ Dashboard ] ===");
	            System.out.println("ID\t: " + rs.getInt("id"));
	            System.out.println("Email\t: " + rs.getString("emailAddress"));
	            System.out.println("Shpping address\t: " + rs.getString("shippingAddress"));
	            System.out.println("Date of birth: " + rs.getDate("dateOfBirth"));
	            System.out.println("Billing cycle: " + rs.getString("billingCycle"));
	            System.out.println("=====================================\n");
	        } else {
	            System.out.println("\n[ تنبيه ]: لا توجد بيانات اشتراك حالية لهذا العميل.\n");
	        }
	    } catch (SQLException e) {
	        System.out.println("ERROR: " + e.getMessage());
	    }
			//System.out.println(customerDAO.getCustomerDashboardData(cus.getId()));
		}
		else if (ch == 5) {
			System.out.println("Thank you for using our system---Bye");
			mc = false;
		}
		else {
			System.out.println("Invalid selection.");
		}
	}
}

private static void adminMenu() {
	boolean inAdminMenu = true;
	while (inAdminMenu) {
		System.out.println("1. UpdateTierPriceInDB");
		System.out.println("2. InsertBenefitRule");
		System.out.println("3. Log out");
		System.out.print("Please select: ");
		int adminChoice = input.nextInt();

		if (adminChoice == 1) {
			System.out.print("Enter Tier ID:");
			int tierId = input.nextInt();
			System.out.print("if monthly true || if annually false: ");
			boolean isMonthly = input.nextBoolean();
			System.out.print("Enter new price: ");
			double newPrice = input.nextDouble();
			adminDAO.updateTierPriceInDB(tierId, isMonthly, newPrice);
		}
		else if (adminChoice == 2) {
			System.out.print("Enter benefit name: ");
			String benefitName = input.next();
			System.out.print("Enter benefit description: ");
			String benefitDesc = input.next();
			adminDAO.insertBenefitRule(benefitName, benefitDesc);
		}
		else if (adminChoice == 3) {
			System.out.println("Thanks...");
			inAdminMenu = false;
		}
		else {
			System.out.println("Invalid selection.");
		}
	}
}
}
