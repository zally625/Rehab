package crud.backend;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the estimates database table.
 * 
 */
@Entity
@Table(name="estimates")
@NamedQuery(name="Estimate.findAll", query="SELECT e FROM Estimate e")
public class Estimate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="estimate_id")
	private int estimateId;

	@Temporal(TemporalType.DATE)
	@Column(name="e_deadline")
	private Date eDeadline;

	@Column(name="e_quote")
	private double eQuote;

	//bi-directional many-to-one association to Contractor
	@ManyToOne
	@JoinColumn(name="e_contractor")
	private Contractor contractor;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="e_task")
	private Task task;

	public Estimate() {
	}

	public int getEstimateId() {
		return this.estimateId;
	}

	public void setEstimateId(int estimateId) {
		this.estimateId = estimateId;
	}

	public Date getEDeadline() {
		return this.eDeadline;
	}

	public void setEDeadline(Date eDeadline) {
		this.eDeadline = eDeadline;
	}

	public double getEQuote() {
		return this.eQuote;
	}

	public void setEQuote(double eQuote) {
		this.eQuote = eQuote;
	}

	public Contractor getContractor() {
		return this.contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}