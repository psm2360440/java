package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

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
		String selectSql = "SELECT * FROM cust WHERE id = ?";
		
		// Statement 생성 - SQL 
		// SQL 전송 (데이터베이스에 질의)

		try ( Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement pstmt = con.prepareStatement(selectSql);) {
			pstmt.setString(1, "id41");
			try(ResultSet rset = pstmt.executeQuery()){
				rset.next(); //	한칸 이동시킴.
				String db_id = rset.getString("id");	// 1번째부터 자리 시작함
				String db_pwd = rset.getString("pwd");
				String name = rset.getString("name");
				int age = rset.getInt("age");
				System.out.println(db_id+""+name+""+age);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
