package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.OrdersVo;

public class OrdersDao {
	public List<OrdersVo> findAll() {
		List<OrdersVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "select no, members_no, orders_no, payment, delevery from orders";
			pstmt = conn.prepareStatement(sql);

			// 4. binding
			// 필요없음

			// 5. SQL 실행
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Long no = rs.getLong(1);
				Long members_no = rs.getLong(2);
				Long orders_no = rs.getLong(3);
				Long payment = rs.getLong(4);
				String delevery = rs.getString(5);

				OrdersVo vo = new OrdersVo();
				vo.setNo(no);
				vo.setMembers_no(members_no);
				vo.setOrders_no(orders_no);
				vo.setPayment(payment);
				vo.setDelevery(delevery);

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

	public boolean insert(OrdersVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. SQL문 준비
			// 주키는 현재 오토 인크리즈먼트 상태
			// members_no는 외래키
			String sql = "insert into orders values(null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(binding)
			pstmt.setLong(1, vo.getMembers_no());
			pstmt.setLong(2, vo.getOrders_no());
			pstmt.setLong(3, vo.getPayment());
			pstmt.setString(4, vo.getDelevery());

			// 4. SQL 실행
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
			String url = "jdbc:mysql://127.0.0.1:3306/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}

		return conn;
	}

}
