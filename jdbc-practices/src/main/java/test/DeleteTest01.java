package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest01 {

	public static void main(String[] args) {

		Boolean result = delete(5L);
		// 삼항연산자
		System.out.println(result ? "성공" : "실패");
	}

	private static Boolean delete(long no) {
		
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;

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
			String sql = "delete from dept where no = " + no;
			int count = stmt.executeUpdate(sql);

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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

}