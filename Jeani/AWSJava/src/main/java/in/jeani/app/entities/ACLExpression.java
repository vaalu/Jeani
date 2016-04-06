package in.jeani.app.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ACLExpression database table.
 * 
 */
@Entity
@NamedQuery(name="ACLExpression.findAll", query="SELECT a FROM ACLExpression a")
public class ACLExpression implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String expression;

	//bi-directional many-to-one association to ACLControl
	@ManyToOne
	@JoinColumn(name="ACLControlId")
	private ACLControl aclcontrol;

	//bi-directional many-to-one association to ACLPermission
	@OneToMany(mappedBy="aclexpression", fetch=FetchType.EAGER)
	private List<ACLPermission> aclpermissions;

	public ACLExpression() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExpression() {
		return this.expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public ACLControl getAclcontrol() {
		return this.aclcontrol;
	}

	public void setAclcontrol(ACLControl aclcontrol) {
		this.aclcontrol = aclcontrol;
	}

	public List<ACLPermission> getAclpermissions() {
		return this.aclpermissions;
	}

	public void setAclpermissions(List<ACLPermission> aclpermissions) {
		this.aclpermissions = aclpermissions;
	}

	public ACLPermission addAclpermission(ACLPermission aclpermission) {
		getAclpermissions().add(aclpermission);
		aclpermission.setAclexpression(this);

		return aclpermission;
	}

	public ACLPermission removeAclpermission(ACLPermission aclpermission) {
		getAclpermissions().remove(aclpermission);
		aclpermission.setAclexpression(null);

		return aclpermission;
	}

}