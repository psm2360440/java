package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest {

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
		String deleteSql = "DELETE FROM cust WHERE ID =?";
		
		// Statement 생성 - SQL 
		// SQL 전송 (데이터베이스에 질의)

		try ( Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement pstmt = con.prepareStatement(deleteSql);) {
			pstmt.setString(1, "id37");
			int result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
