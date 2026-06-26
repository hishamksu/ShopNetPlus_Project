package NetPlus;
import java.util.Scanner;
import java.sql.*;
import java.time.LocalDate;

public class AdminDAO {
	Scanner input = new Scanner(System.in);
	
	public void updateTierPriceInDB(int id, boolean isMonthly, double newPrice) {
		
		String sql = "";
		if(isMonthly) {sql = "UPDATE SubscriptionTier SET monthlyPrice = ? WHERE stid = ?";}
		else {sql = "UPDATE SubscriptionTier SET annualPrice = ? WHERE stid = ?";}
		
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setDouble(1, newPrice);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertBenefitRule(String benefitName, String benefitDescription) {
		
		String sql = "INSERT INTO benefit(benefitName,benefitDescription) VALUES (?,?)";
		
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, benefitName);
			pstmt.setString(2, benefitDescription);
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
