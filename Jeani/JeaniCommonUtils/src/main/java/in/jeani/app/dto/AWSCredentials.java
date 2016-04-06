/**
 * 
 */
package in.jeani.app.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author mohanavelp
 *
 */
@Component
public class AWSCredentials {
	
	@Value("${environment}")
	private String awsAccessKey;
	
	@Value("${environment}")
	private String awsSecretKey;

	/**
	 * @return the awsAccessKey
	 */
	public String getAwsAccessKey() {
		return awsAccessKey;
	}

	/**
	 * @param awsAccessKey the awsAccessKey to set
	 */
	public void setAwsAccessKey(String awsAccessKey) {
		this.awsAccessKey = awsAccessKey;
	}

	/**
	 * @return the awsSecretKey
	 */
	public String getAwsSecretKey() {
		return awsSecretKey;
	}

	/**
	 * @param awsSecretKey the awsSecretKey to set
	 */
	public void setAwsSecretKey(String awsSecretKey) {
		this.awsSecretKey = awsSecretKey;
	}
}
