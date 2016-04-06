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
public class SQLConnection implements AutoCloseable {

	private Connection connection = null;
	
	@Autowired
	private JdbcConnectionProperties connectionProps;
	
	public Connection openConnection() throws ClassNotFoundException, SQLException {
		return JdbcConnectionFactory.createConnection(connectionProps.getDriver(), connectionProps.getUrl(), connectionProps.getUserName(), connectionProps.getPassword());
	}
	
	@Override
	public void close() throws Exception {
		if(connection != null) {
			connection.close();
		}
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**
	 * @return the connectionProps
	 */
	public JdbcConnectionProperties getConnectionProps() {
		return connectionProps;
	}

	/**
	 * @param connectionProps the connectionProps to set
	 */
	public void setConnectionProps(JdbcConnectionProperties connectionProps) {
		this.connectionProps = connectionProps;
	}

}
