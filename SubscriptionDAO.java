package NetPlus;
import java.util.Scanner;
import java.sql.*;
import java.time.LocalDate;

public class SubscriptionDAO {
	
	Scanner input = new Scanner(System.in);


public void insertSubscription(int cid, int stid, String billingCycle, String subscriptionStatus) {
	
	String sql = "INSERT INTO Subscription(cid,stid,startDate,nextRenwalDate,billingCycle,subscriptionStatus)"
			+ " VALUES(?,?,NOW(), IF(? = 'Monthly', DATE_ADD(NOW(), INTERVAL 1 Month),DATE_ADD(NOW(),INTERVAL 1 YEAR), ?, ?)";

try(Connection conn = DBConnection.getConnection();
	PreparedStatement pstmt = conn.prepareStatement(sql)) {
	
	pstmt.setInt(1,cid);
	pstmt.setInt(2,stid);
	pstmt.setString(3, billingCycle);
	pstmt.setString(4, billingCycle);
	pstmt.setString(5, subscriptionStatus);
	pstmt.executeUpdate();
	System.out.println("Added successfully");
}
catch (SQLException e) {
	e.printStackTrace();
}
}
public void updateSubscriptionTier(int newstid, int cid) {
	
	String sql = "UPDATE Subscription SET stid = ? WHERE cid = ?";
	
	try(Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
	
	pstmt.setInt(1, newstid);
	pstmt.setInt(2, cid);
	
	pstmt.executeUpdate();
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	}
		
	
			
public void updateSubscriptionStatus(String newStatus, int cid) {
	
	String sql = "UPDATE Subscription SET subscriptionStatus = ? WHERE cid = ?";
	
	try(Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
		
		pstmt.setString(1, newStatus);
		pstmt.setInt(2, cid);
		
		pstmt.executeUpdate();
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
}





		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
