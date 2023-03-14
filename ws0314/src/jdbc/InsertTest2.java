package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest2 {

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
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, id, pwd);
		} catch (SQLException e) {
			System.out.println("접속 실패 !!");
			e.printStackTrace();
			return;
		}
		System.out.println("접속 성공 !!");
		
		
		
		// Statement 생성 - SQL 
		// SQL 전송 (데이터베이스에 질의)
		String insertSql = "INSERT INTO cust VALUES(?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(insertSql);
			pstmt.setString(1, "id17");
			pstmt.setString(2, "pwd17");
			pstmt.setString(3, "김보고");
			pstmt.setInt(4, 31);
			int result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		// 결과 받기
		
		// Close
		try {
			if( con !=null ) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("close 실패 !!");
			e.printStackTrace();
		}
		
		System.out.println("close 성공 !!");

	}

}
