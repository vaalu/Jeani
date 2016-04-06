/**
 * 
 */
package in.jeani.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import in.jeani.app.entities.ACLExpression;

/**
 * @author mohanavelp
 *
 */
public interface ACLExpressionDAO extends JpaRepository<ACLExpression, String>{

	@Modifying
	@Transactional
	@Query("update ACLExpression e set e.Expression=:expression where e.ACLControlId=:aclcontrolid")
	void updateForControl(@Param("aclcontrolid") String aclControlId, @Param("expression") String expression);
}
