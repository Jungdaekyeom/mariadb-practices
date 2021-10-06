package driver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class MyDriver implements Driver {

	// MyDriver 클래스의 public class MyDriver implements Driver 바로 밑의 구간에서 실행이 시작됨
	static {
		try {
			System.out.println("static code area");
			DriverManager.registerDriver(new MyDriver()); // try-catch문 필요
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}
	

	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		
		System.out.println("url" + url);
		System.out.println("info" + info);
		
		return new MyConnection();
	}

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMajorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean jdbcCompliant() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

}
