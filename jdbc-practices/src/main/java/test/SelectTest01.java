package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest01 {

	public static void main(String[] args) {

		search("pat");

	}

	// select는 ResultSet로 해야한다.
	private static void search(String keyword) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			// 연결 url 필요
			String url = "jdbc:mysql://127.0.0.1:3307/webdb";
			conn = DriverManager.getConnection(url, "hr", "hr");

			// 3. Statement 생성
			stmt = conn.createStatement();

			// 4. SQL 실행
			// String sql = "insert into dept values(null, '총무');";
			String sql = "select emp_no, first_name from employees where first_name like %" + keyword + "%";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// getLong은 0부터가 아니라 1부터
				Long empNo = rs.getLong(1);
				String firstName = rs.getString(2);
				System.out.println(empNo + ":" + firstName);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// clean up
			try {
				if (rs != null) {
					rs.close(); // 커넥션 테스트
				}
				
				if (stmt != null) {
					stmt.close(); // 커넥션 테스트
				}
				
				if (conn != null) {
					conn.close(); // 커넥션 테스트
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
