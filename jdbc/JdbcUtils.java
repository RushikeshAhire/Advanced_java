package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtils {
	public static Connection buildConnection() throws Exception {
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		String connectionURL = "jdbc:mysql://localhost:3306/db1";
		String userId = "root";
		String password = "root";
		Class.forName(driverClassName);
		Connection conn =  DriverManager.getConnection(connectionURL, userId, password);
		return conn;
	}

}
