package crud.backend;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the specialities database table.
 * 
 */
@Entity
@Table(name="specialities")
@NamedQuery(name="Speciality.findAll", query="SELECT s FROM Speciality s")
public class Speciality implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="speciality_id")
	private int specialityId;

	@Column(name="s_type")
	private String sType;

	//bi-directional many-to-one association to ContractorsSpeciality
	@OneToMany(mappedBy="speciality")
	private List<ContractorsSpeciality> contractorsSpecialities;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="speciality")
	private List<Task> tasks;

	public Speciality() {
	}

	public int getSpecialityId() {
		return this.specialityId;
	}

	public void setSpecialityId(int specialityId) {
		this.specialityId = specialityId;
	}

	public String getSType() {
		return this.sType;
	}

	public void setSType(String sType) {
		this.sType = sType;
	}

	public List<ContractorsSpeciality> getContractorsSpecialities() {
		return this.contractorsSpecialities;
	}

	public void setContractorsSpecialities(List<ContractorsSpeciality> contractorsSpecialities) {
		this.contractorsSpecialities = contractorsSpecialities;
	}

	public ContractorsSpeciality addContractorsSpeciality(ContractorsSpeciality contractorsSpeciality) {
		getContractorsSpecialities().add(contractorsSpeciality);
		contractorsSpeciality.setSpeciality(this);

		return contractorsSpeciality;
	}

	public ContractorsSpeciality removeContractorsSpeciality(ContractorsSpeciality contractorsSpeciality) {
		getContractorsSpecialities().remove(contractorsSpeciality);
		contractorsSpeciality.setSpeciality(null);

		return contractorsSpeciality;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setSpeciality(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setSpeciality(null);

		return task;
	}

}