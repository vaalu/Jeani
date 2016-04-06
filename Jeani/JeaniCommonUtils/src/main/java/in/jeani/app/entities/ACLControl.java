package in.jeani.app.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the ACLControl database table.
 * 
 */
@Entity
@NamedQuery(name="ACLControl.findAll", query="SELECT a FROM ACLControl a")
public class ACLControl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String createdBy;

	private Timestamp createdDateTime;

	private Timestamp lastUpdateDateTime;

	private String lastUpdatedBy;

	private String objectId;

	private String objectType;

	//bi-directional many-to-one association to ACLExpression
	@OneToMany(mappedBy="aclcontrol", fetch=FetchType.EAGER)
	private List<ACLExpression> aclexpressions;

	public ACLControl() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDateTime() {
		return this.createdDateTime;
	}

	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Timestamp getLastUpdateDateTime() {
		return this.lastUpdateDateTime;
	}

	public void setLastUpdateDateTime(Timestamp lastUpdateDateTime) {
		this.lastUpdateDateTime = lastUpdateDateTime;
	}

	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getObjectId() {
		return this.objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getObjectType() {
		return this.objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public List<ACLExpression> getAclexpressions() {
		return this.aclexpressions;
	}

	public void setAclexpressions(List<ACLExpression> aclexpressions) {
		this.aclexpressions = aclexpressions;
	}

	public ACLExpression addAclexpression(ACLExpression aclexpression) {
		getAclexpressions().add(aclexpression);
		aclexpression.setAclcontrol(this);

		return aclexpression;
	}

	public ACLExpression removeAclexpression(ACLExpression aclexpression) {
		getAclexpressions().remove(aclexpression);
		aclexpression.setAclcontrol(null);

		return aclexpression;
	}

}