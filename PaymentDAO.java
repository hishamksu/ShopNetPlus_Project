package NetPlus;
import java.util.Scanner;
import java.sql.*;
import java.time.LocalDate;


public class PaymentDAO {
	Scanner input = new Scanner(System.in);
	
	
public boolean processPaymentTransaction(int sid, double transactionAmount, String paymentMethod, String transactionStatus) {
	
	String sql = "INSERT INTO Payment(sid,transactionAmount,paymentDate,paymentMethod,transactionStatus) "
			+ "VALUES (?,?,NOW(),?,?)";
	
	try(Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
		
		pstmt.setInt(1, sid);
		pstmt.setDouble(2, transactionAmount);
		pstmt.setString(3,paymentMethod);
		pstmt.setString(4, transactionStatus);
		int rowsAffected = pstmt.executeUpdate();
		return rowsAffected > 0;
	}
	catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
