package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest02 {

	public static void main(String[] args) {

		DeptVo vo = new DeptVo();
		vo.setNo(11L);
		vo.setName("전략기획팀");

		Boolean result = update(vo);
		if (result) {
			System.out.println("성공!");
		}
	}

	private static Boolean update(DeptVo vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			// 연결 url 필요
			String url = "jdbc:mysql://127.0.0.1:3307/employees?charset=utf8";
			conn = DriverManager.getConnection(url, "hr", "hr");

			//3. SQL 준비
			String sql = "update dept set name=? where no=?";
			pstmt = conn.prepareStatement(sql);
			
			//4. binding
			pstmt.setString(1, vo.getName());
			pstmt.setLong(2, vo.getNo());
			
			//5. SQL 실행
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
