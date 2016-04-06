package in.jeani.app.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ACLPermission database table.
 * 
 */
@Entity
@NamedQuery(name="ACLPermission.findAll", query="SELECT a FROM ACLPermission a")
public class ACLPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String operation;

	private String permission;

	//bi-directional many-to-one association to ACLExpression
	@ManyToOne
	@JoinColumn(name="ACLExpressionId")
	private ACLExpression aclexpression;

	public ACLPermission() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public ACLExpression getAclexpression() {
		return this.aclexpression;
	}

	public void setAclexpression(ACLExpression aclexpression) {
		this.aclexpression = aclexpression;
	}

}