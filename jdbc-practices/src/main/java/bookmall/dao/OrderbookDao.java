package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.OrderbookVo;

public class OrderbookDao {

	public List<OrderbookVo> findAll() {
		List<OrderbookVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "select orders_no, book_no, amount from orderbook";
			pstmt = conn.prepareStatement(sql);

			// 4. binding
			// 필요없음

			// 5. SQL 실행
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Long orders_no = rs.getLong(1);
				Long book_no = rs.getLong(2);
				Long amount = rs.getLong(3);

				OrderbookVo vo = new OrderbookVo();
				vo.setOrders_no(orders_no);
				vo.setBook_no(book_no);
				vo.setAmount(amount);
				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// clean up
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean insert(OrderbookVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "insert into orderbook values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(binding)
			pstmt.setLong(1, vo.getOrders_no());
			pstmt.setLong(2, vo.getBook_no());
			pstmt.setLong(3, vo.getAmount());

			// 5. SQL 실행

			// executeUpdate()
			// 1. 수행결과로 Int 타입의 값을 반환합니다.
			// 2. SELECT 구문을 제외한 다른 구문을 수행할 때 사용되는 함수입니다.

			// executeUpdate 함수를 사용하는 방법입니다.
			// -> INSERT / DELETE / UPDATE 관련 구문에서는 반영된 레코드의 건수를 반환합니다.
			// -> CREATE / DROP 관련 구문에서는 -1 을 반환합니다.
			// 무튼, 무언가가 반횐되었음.
			// 반환되지 않았다면 여기서 에러가 발생할 것.
			int count = pstmt.executeUpdate();

			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// clean up
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;

	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}

		return conn;
	}

}
