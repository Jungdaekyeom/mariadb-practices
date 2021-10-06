package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest01 {

	public static void main(String[] args) {

		DeptVo vo = new DeptVo();
		vo.setNo(8L);
		vo.setName("전략기획팀");

		Boolean result = update(vo);
		if (result) {
			System.out.println("성공!");
		}
	}

	private static Boolean update(DeptVo vo) {

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
			String sql = "update dept " + 
						 "set name ='" + vo.getName() + "'" +
						 "where no =" + vo.getNo();
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
				
				if (stmt != null) {
					stmt.close(); // 커넥션 테스트
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
