package NetPlus;
import java.util.Scanner;
import java.sql.*;
import java.time.LocalDate;

public class CustomerDAO {

	Scanner input = new Scanner(System.in);
	
public void insertCustomer(int id,String emailAddress,int passwordHush, String shippingAddress,LocalDate datrOfBirth, String notificationPreferences) {
	
	String sql = "INSERT INTO Customer (id,emailAddress,passwordHush,registrationDate,shippingAddress,datrOfBirth,notificationPreferences) VALUES (?,?,?,NOW(),?,?,?)";
	
	try (Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1,id);
			pstmt.setString(2, emailAddress);
			pstmt.setInt(3,passwordHush);
			//pstmt.setDate(4, java.sql.Date.valueOf(registrationDate));
			pstmt.setString(4, shippingAddress);
			pstmt.setDate(5, java.sql.Date.valueOf(datrOfBirth));
			pstmt.setString(6, notificationPreferences);
			
			pstmt.executeUpdate();
			System.out.println("Added successfully");
		}
	catch (SQLException e) {
		e.printStackTrace();
	}
}
	public boolean chekLogIn(int id,String emailAddress, String passwordHush) {
		
		String sql = "SELECT * FROM Customer WHERE id = ? AND emailAddress = ? AND passwordHush = ?";
		
		try(Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql)) {
		pstmt.setInt(1,id);
		pstmt.setString(2,emailAddress);
		pstmt.setString(3,passwordHush);
		ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					// if (id == rs.getInt("id") & emailAddress.equalsIgnoreCase(rs.getString("emailAddress")) & passwordHush == rs.getInt("passwordHush")) {
						System.out.print("Welcome back");
						return true;
					}
					else {System.out.print("Error");
					return false;
					}
				}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
public ResultSet getCustomerDashboardData (int id) {
	
	String sql = "SELECT * FROM Customer c JOIN Subscription s ON c.id = s.Cid WHERE c.id = ?";
	try(Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		return rs;
		
	}
	catch (SQLException e) {
		e.printStackTrace();
		return null;
		}
}

// public void updateCustomerPoints(int id,int newPoints) {
	







	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	
	
	
	
	
	

