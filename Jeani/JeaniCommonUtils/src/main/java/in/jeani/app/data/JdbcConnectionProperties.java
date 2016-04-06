package in.jeani.app.data;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JdbcConnectionProperties {

	private final String driver;
	private final String url;
	private final String userName;
	private final String password;

	@Autowired
	public JdbcConnectionProperties(@Value("${jeani.db.driver}") String driver,
			@Value("${jeani.db.url}") String url,
			@Value("${jeani.db.username}") String userName,
			@Value("${jeani.db.password}") String password) {
		this.driver = driver;
		this.url = url;
		this.userName = userName;
		this.password = password;
	}

	public JdbcConnectionProperties(Map<String, String> props) {

		driver = props.get("jdbc.driver");
		url = props.get("jdbc.url");

		userName = props.get("jdbc.username");
		password = props.get("jdbc.password");

	}

	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

}
