/**
 * 
 */
package in.jeani.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.jeani.app.entities.ACLPermission;

/**
 * @author mohanavelp
 *
 */
public interface ACLPermissionDAO extends JpaRepository<ACLPermission, String> {

}
