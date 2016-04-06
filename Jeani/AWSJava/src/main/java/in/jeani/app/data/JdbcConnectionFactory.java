package in.jeani.app.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 */
public class JdbcConnectionFactory {

	public static Connection createConnection(String driverClassName, String connectionUrl, String userName, String password)
	        throws ClassNotFoundException, SQLException {
		Class.forName(driverClassName);
		Connection conn = DriverManager.getConnection(connectionUrl, userName, password);
		return conn;
	}

}
