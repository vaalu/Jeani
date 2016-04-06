package in.jeani.app;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import in.jeani.app.data.SQLConnection;
import in.jeani.app.data.SQLProcessor;
import in.jeani.app.entities.ACLControl;
import in.jeani.app.entities.ACLExpression;
import in.jeani.app.entities.ACLPermission;
import in.jeani.app.testsupport.BaseTest;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends BaseTest
{
	private static final Logger LOGGER = org.apache.log4j.Logger.getLogger(AppTest.class);
	
	@Autowired
	private SQLConnection conn;
	
	@Autowired
	private SQLProcessor processor;
	
	public static void logStatement() {
	}
	
	@Ignore
	@Test
	public void testMethod() {
		
		try {
			LOGGER.debug("Connection property: " + conn.openConnection());
			if (conn != null) {
				LOGGER.debug("Connection property: " + conn.getConnectionProps().getUserName());
			} else {
				LOGGER.debug("Connection property is null");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(true);
	}
	
	@Ignore
	@Test
	public void testSQLMethod() {
		
		try {
			LOGGER.debug("Testing JPA...");
			processor.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(true);
	}
	
	@Ignore
	@Test
	public void testACLControlSave() {
		
		try {
			LOGGER.debug("Testing JPA...");
			processor.executeQuery();
			processor.saveControl(getACLControl());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(true);
	}
	
	@Ignore
	@Test
	public void testACLControlUpdateForControl() {
		
		try {
			LOGGER.debug("Testing JPA...");
			processor.executeQuery();
			processor.updateForControl(getACLControlForUpdate());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(true);
	}
	
	private ACLControl getACLControlForUpdate() {
		ACLControl control = getACLControl();
		control.setId("32");
		control.getAclexpressions().get(0).setExpression("userName==mohanavelp@nousinfo.com");
		return control;
	}
	
	private ACLControl getACLControl() {
		ACLControl control = new ACLControl();
		
		control.setObjectId("d148cbc2bc3c11d4caa8b0f34690276c3ea3bc9e");
		control.setObjectType("Application");
		control.setCreatedBy("mohanavelp@digitalinfuzion.com");
		control.setCreatedDateTime(new Timestamp(new Date().getTime()));
		control.setLastUpdateDateTime(new Timestamp(new Date().getTime()));
		control.setLastUpdatedBy("mohanavelp@digitalinfuzion.com");
		
		ACLExpression expression = new ACLExpression();
		expression.setExpression("userName==mohanavelp@digitalinfuzion.com");
		expression.setAclcontrol(control);
		
		ArrayList<ACLPermission> permissions = new ArrayList<ACLPermission>();
		ACLPermission permission = new ACLPermission();
		permission.setOperation("UPDATE");
		permission.setPermission("A");
		permission.setAclexpression(expression);
		permissions.add(permission);
		
		permission = new ACLPermission();
		permission.setOperation("MANAGE");
		permission.setPermission("A");
		permission.setAclexpression(expression);
		permissions.add(permission);
		
		expression.setAclpermissions(permissions);
		
		ArrayList<ACLExpression> expressions = new ArrayList<ACLExpression>();
		expressions.add(expression);
		
		control.setAclexpressions(expressions);
		
		return control;
	}
	
}
