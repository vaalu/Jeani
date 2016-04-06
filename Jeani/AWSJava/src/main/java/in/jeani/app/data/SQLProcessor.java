/**
 * 
 */
package in.jeani.app.data;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mohanavelp
 *
 */
@Component
public class SQLProcessor {

	@Autowired
	private SQLConnection sql;
	
	public void executeQuery() {
		Connection conn;
		try {
			conn = sql.openConnection();
			conn.getMetaData().getDatabaseProductName();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
}
