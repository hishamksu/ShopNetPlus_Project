package NetPlus;
import java.util.Scanner;
import java.sql.*;
import java.time.LocalDate;


public class OrderDAO {
	Scanner input = new Scanner(System.in);
	
public void insertOrderRecord(int cid,double totalOrderValue,double appliedCashback, String deliveryPriority) {
	
	String sql = "INSERT INTO customerorderuse(cid,orderDate,totalOrderValue,appliedCashback,deliveryPriority)"
			+ " VALUES(?,NOW(),?,?,?)";
	
	try(Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
		pstmt.setInt(1, cid);
		pstmt.setDouble(2, totalOrderValue);
		pstmt.setDouble(3, appliedCashback);
		pstmt.setString(4, deliveryPriority);
		pstmt.executeUpdate();
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	
}
	
	
}
