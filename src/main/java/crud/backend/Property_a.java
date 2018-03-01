package crud.backend;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the properties database table.
 * 
 */
@Entity
@Table(name="properties")
@NamedQuery(name="Property_a.findAll", query="SELECT p FROM Property_a p")
public class Property_a implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="property_id")
	private Long propertyId;

	@Column(name="p_city")
	private String pCity;

	@Temporal(TemporalType.DATE)
	@Column(name="p_goal_complete_date")
	private Date pGoalCompleteDate;

	@Column(name="p_name")
	private String pName;

	@Temporal(TemporalType.DATE)
	@Column(name="p_purchase_date")
	private Date pPurchaseDate;

	@Column(name="p_purchase_price")
	private double pPurchasePrice;

	@Column(name="p_state")
	private String pState;

	@Column(name="p_street_address1")
	private String pStreetAddress1;

	@Column(name="p_street_address2")
	private String pStreetAddress2;

	@Column(name="p_total_budget")
	private double pTotalBudget;

	@Column(name="p_zipcode")
	private String pZipcode;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="property")
	private List<Task> tasks;

	public Property_a() {
	}

	public Long getPropertyId() {
		return this.propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public String getPCity() {
		return this.pCity;
	}

	public void setPCity(String pCity) {
		this.pCity = pCity;
	}

	public Date getPGoalCompleteDate() {
		return this.pGoalCompleteDate;
	}

	public void setPGoalCompleteDate(Date pGoalCompleteDate) {
		this.pGoalCompleteDate = pGoalCompleteDate;
	}

	public String getPName() {
		return this.pName;
	}

	public void setPName(String pName) {
		this.pName = pName;
	}

	public Date getPPurchaseDate() {
		return this.pPurchaseDate;
	}

	public void setPPurchaseDate(Date pPurchaseDate) {
		this.pPurchaseDate = pPurchaseDate;
	}

	public double getPPurchasePrice() {
		return this.pPurchasePrice;
	}

	public void setPPurchasePrice(double pPurchasePrice) {
		this.pPurchasePrice = pPurchasePrice;
	}

	public String getPState() {
		return this.pState;
	}

	public void setPState(String pState) {
		this.pState = pState;
	}

	public String getPStreetAddress1() {
		return this.pStreetAddress1;
	}

	public void setPStreetAddress1(String pStreetAddress1) {
		this.pStreetAddress1 = pStreetAddress1;
	}

	public String getPStreetAddress2() {
		return this.pStreetAddress2;
	}

	public void setPStreetAddress2(String pStreetAddress2) {
		this.pStreetAddress2 = pStreetAddress2;
	}

	public double getPTotalBudget() {
		return this.pTotalBudget;
	}

	public void setPTotalBudget(double pTotalBudget) {
		this.pTotalBudget = pTotalBudget;
	}

	public String getPZipcode() {
		return this.pZipcode;
	}

	public void setPZipcode(String pZipcode) {
		this.pZipcode = pZipcode;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setProperty(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setProperty(null);

		return task;
	}

}