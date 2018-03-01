package crud.backend;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tasks database table.
 * 
 */
@Entity
@Table(name="tasks")
@NamedQuery(name="Task.findAll", query="SELECT t FROM Task t")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="task_id")
	private int taskId;

	@Temporal(TemporalType.DATE)
	@Column(name="t_acutal_complete_date")
	private Date tAcutalCompleteDate;

	@Column(name="t_acutal_price")
	private double tAcutalPrice;

	@Column(name="t_budget_price")
	private double tBudgetPrice;

	@Column(name="t_detail_description")
	private String tDetailDescription;

	@Column(name="t_estimate_selected")
	private int tEstimateSelected;

	@Temporal(TemporalType.DATE)
	@Column(name="t_goal_complete_date")
	private Date tGoalCompleteDate;

	@Column(name="t_notes")
	private String tNotes;

	//bi-directional many-to-one association to Estimate
	@OneToMany(mappedBy="task")
	private List<Estimate> estimates;

	//bi-directional many-to-one association to Speciality
	@ManyToOne
	@JoinColumn(name="t_specialty")
	private Speciality speciality;

	//bi-directional many-to-one association to Property_a
	@ManyToOne
	@JoinColumn(name="t_property")
	private Property_a property;

	public Task() {
	}

	public int getTaskId() {
		return this.taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public Date getTAcutalCompleteDate() {
		return this.tAcutalCompleteDate;
	}

	public void setTAcutalCompleteDate(Date tAcutalCompleteDate) {
		this.tAcutalCompleteDate = tAcutalCompleteDate;
	}

	public double getTAcutalPrice() {
		return this.tAcutalPrice;
	}

	public void setTAcutalPrice(double tAcutalPrice) {
		this.tAcutalPrice = tAcutalPrice;
	}

	public double getTBudgetPrice() {
		return this.tBudgetPrice;
	}

	public void setTBudgetPrice(double tBudgetPrice) {
		this.tBudgetPrice = tBudgetPrice;
	}

	public String getTDetailDescription() {
		return this.tDetailDescription;
	}

	public void setTDetailDescription(String tDetailDescription) {
		this.tDetailDescription = tDetailDescription;
	}

	public int getTEstimateSelected() {
		return this.tEstimateSelected;
	}

	public void setTEstimateSelected(int tEstimateSelected) {
		this.tEstimateSelected = tEstimateSelected;
	}

	public Date getTGoalCompleteDate() {
		return this.tGoalCompleteDate;
	}

	public void setTGoalCompleteDate(Date tGoalCompleteDate) {
		this.tGoalCompleteDate = tGoalCompleteDate;
	}

	public String getTNotes() {
		return this.tNotes;
	}

	public void setTNotes(String tNotes) {
		this.tNotes = tNotes;
	}

	public List<Estimate> getEstimates() {
		return this.estimates;
	}

	public void setEstimates(List<Estimate> estimates) {
		this.estimates = estimates;
	}

	public Estimate addEstimate(Estimate estimate) {
		getEstimates().add(estimate);
		estimate.setTask(this);

		return estimate;
	}

	public Estimate removeEstimate(Estimate estimate) {
		getEstimates().remove(estimate);
		estimate.setTask(null);

		return estimate;
	}

	public Speciality getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public Property_a getProperty() {
		return this.property;
	}

	public void setProperty(Property_a property) {
		this.property = property;
	}

}