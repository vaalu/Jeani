/**
 * 
 */
package in.jeani.app.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.jeani.app.dao.ACLControlDAO;
import in.jeani.app.dao.ACLExpressionDAO;
import in.jeani.app.dao.ACLPermissionDAO;
import in.jeani.app.entities.ACLControl;
import in.jeani.app.entities.ACLExpression;
import in.jeani.app.entities.ACLPermission;

/**
 * @author mohanavelp
 *
 */
@Component
public class SQLProcessor {
	private static final Logger LOGGER = org.apache.log4j.Logger.getLogger(SQLProcessor.class);
	
	@Autowired
	private ACLControlDAO aclControlDAO;
	
	@Autowired
	private ACLExpressionDAO aclExpressionDAO;
	
	@Autowired
	private ACLPermissionDAO aclPermissionDAO;
	
	public void executeQuery() {
		LOGGER.debug("Executing query from SQLProcessor");
		ACLControl control =  aclControlDAO.findOne("23");
		LOGGER.debug("Result : " + control.getObjectId());
	}
	
	public void saveControl(ACLControl control) {
		
		if (control != null) {
			List<ACLExpression> expressions = control.getAclexpressions();
			List<ACLPermission> consolidatedPermissions = new ArrayList<ACLPermission>(); 
			
			if (expressions != null && !expressions.isEmpty()) {
				for (ACLExpression expression : expressions) {
					List<ACLPermission> permissions = expression.getAclpermissions();
					consolidatedPermissions.addAll(permissions);
				}
			}
			
			aclControlDAO.save(control);
			aclExpressionDAO.save(expressions);
			aclPermissionDAO.save(consolidatedPermissions);
			
		}
	}
	
	public void updateForControl(ACLControl control) {
		
		if (control != null) {
			List<ACLExpression> expressions = control.getAclexpressions();
			
			if (expressions != null && !expressions.isEmpty()) {
				for (ACLExpression expression : expressions) {
					LOGGER.debug("Updating for expression: " + expression.getExpression());
					//aclExpressionDAO.updateForControl(control.getId(), expression.getExpression());
				}
			}
		}
	}
}
