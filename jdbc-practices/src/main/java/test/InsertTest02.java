package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest02 {
	public static void main(String[] args) {

		insert("영업");
		insert("개발");
		insert("기획");

	}

	private static boolean insert(String name) {

		boolean result = false;
		Connection conn = null;
		// Statement의 상위호환
		PreparedStatement pstmt = null;

		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			// 연결 url 필요
			String url = "jdbc:mysql://127.0.0.1:3307/employees?charset=utf8";
			conn = DriverManager.getConnection(url, "hr", "hr");

			// 3. SQL문 준비
			// String sql = "insert into dept values(null, ?);";
			String sql = "insert into dept values(null, ?);";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(binding)
			pstmt.setString(1, name);

			// 5. SQL 실행
			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// clean up
			try {
				if (conn != null) {
					conn.close(); // 커넥션 테스트
				}

				if (pstmt != null) {
					pstmt.close(); // 커넥션 테스트
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
