package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {

	public static void main(String[] args) {
		// Driver Loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다.");
			e.printStackTrace();
			return;
		}
		System.out.println("Driver Loading 성공.");
		
	
		// Connect
		String id = "bank";// workspace
		String pwd = "111111";
		String url = "jdbc:oracle:thin:@172.16.20.64:1521:XE";
		String insertSql = "INSERT INTO cust VALUES(?,?,?,?)";
		
		// Statement 생성 - SQL 
		// SQL 전송 (데이터베이스에 질의)

		try ( Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement pstmt = con.prepareStatement(insertSql);) {
			pstmt.setString(1, "id01");
			pstmt.setString(2, "pwd37");
			pstmt.setString(3, "오준성");
			pstmt.setInt(4, 4);
			int result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
