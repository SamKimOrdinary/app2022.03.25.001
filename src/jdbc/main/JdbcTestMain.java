package jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTestMain {

	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "student";
	private static final String pwd = "1234";

	public static void main(String[] args) {
		Connection conn;
		Statement stmt;
		ResultSet rs;
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
			
			stmt = conn.createStatement();
			System.out.println("Statement 생성 성공");
			
			String query = "INSERT INTO member VALUES ( '유돌이' , '165', '45' , 18 , '여' )";
			System.out.println(query);
			stmt.executeUpdate(query);
			
			String query2 = "SELECT * FROM member";
			System.out.println(query2);
			rs = stmt.executeQuery(query2);
			while (rs.next()) {
				System.out.print("이름은>>" + rs.getString("name"));
				System.out.print(" 키는>>" + rs.getString("height"));
				System.out.print(" 체중은>>" + rs.getString("weight"));
				System.out.print(" 나이는>>" + rs.getInt("age"));
				System.out.println(" 성별은>>" + rs.getString("sex"));
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
