package crud.backend;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the contractors database table.
 * 
 */
@Entity
@Table(name="contractors")
@NamedQuery(name="Contractor.findAll", query="SELECT c FROM Contractor c")
public class Contractor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="contractor_id")
	private int contractorId;

	@Column(name="c_city")
	private String cCity;

	@Column(name="c_company_name")
	private String cCompanyName;

	@Column(name="c_contact_first_name")
	private String cContactFirstName;

	@Column(name="c_contact_last_name")
	private String cContactLastName;

	@Column(name="c_email")
	private String cEmail;

	@Column(name="c_insurance")
	private String cInsurance;

	@Column(name="c_license")
	private String cLicense;

	@Column(name="c_phone")
	private String cPhone;

	@Column(name="c_state")
	private String cState;

	@Column(name="c_street_address1")
	private String cStreetAddress1;

	@Column(name="c_street_address2")
	private String cStreetAddress2;

	@Column(name="c_zipcode")
	private String cZipcode;

	//bi-directional many-to-one association to ContractorsSpeciality
	@OneToMany(mappedBy="contractor")
	private List<ContractorsSpeciality> contractorsSpecialities;

	//bi-directional many-to-one association to Estimate
	@OneToMany(mappedBy="contractor")
	private List<Estimate> estimates;

	public Contractor() {
	}

	public int getContractorId() {
		return this.contractorId;
	}

	public void setContractorId(int contractorId) {
		this.contractorId = contractorId;
	}

	public String getCCity() {
		return this.cCity;
	}

	public void setCCity(String cCity) {
		this.cCity = cCity;
	}

	public String getCCompanyName() {
		return this.cCompanyName;
	}

	public void setCCompanyName(String cCompanyName) {
		this.cCompanyName = cCompanyName;
	}

	public String getCContactFirstName() {
		return this.cContactFirstName;
	}

	public void setCContactFirstName(String cContactFirstName) {
		this.cContactFirstName = cContactFirstName;
	}

	public String getCContactLastName() {
		return this.cContactLastName;
	}

	public void setCContactLastName(String cContactLastName) {
		this.cContactLastName = cContactLastName;
	}

	public String getCEmail() {
		return this.cEmail;
	}

	public void setCEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getCInsurance() {
		return this.cInsurance;
	}

	public void setCInsurance(String cInsurance) {
		this.cInsurance = cInsurance;
	}

	public String getCLicense() {
		return this.cLicense;
	}

	public void setCLicense(String cLicense) {
		this.cLicense = cLicense;
	}

	public String getCPhone() {
		return this.cPhone;
	}

	public void setCPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	public String getCState() {
		return this.cState;
	}

	public void setCState(String cState) {
		this.cState = cState;
	}

	public String getCStreetAddress1() {
		return this.cStreetAddress1;
	}

	public void setCStreetAddress1(String cStreetAddress1) {
		this.cStreetAddress1 = cStreetAddress1;
	}

	public String getCStreetAddress2() {
		return this.cStreetAddress2;
	}

	public void setCStreetAddress2(String cStreetAddress2) {
		this.cStreetAddress2 = cStreetAddress2;
	}

	public String getCZipcode() {
		return this.cZipcode;
	}

	public void setCZipcode(String cZipcode) {
		this.cZipcode = cZipcode;
	}

	public List<ContractorsSpeciality> getContractorsSpecialities() {
		return this.contractorsSpecialities;
	}

	public void setContractorsSpecialities(List<ContractorsSpeciality> contractorsSpecialities) {
		this.contractorsSpecialities = contractorsSpecialities;
	}

	public ContractorsSpeciality addContractorsSpeciality(ContractorsSpeciality contractorsSpeciality) {
		getContractorsSpecialities().add(contractorsSpeciality);
		contractorsSpeciality.setContractor(this);

		return contractorsSpeciality;
	}

	public ContractorsSpeciality removeContractorsSpeciality(ContractorsSpeciality contractorsSpeciality) {
		getContractorsSpecialities().remove(contractorsSpeciality);
		contractorsSpeciality.setContractor(null);

		return contractorsSpeciality;
	}

	public List<Estimate> getEstimates() {
		return this.estimates;
	}

	public void setEstimates(List<Estimate> estimates) {
		this.estimates = estimates;
	}

	public Estimate addEstimate(Estimate estimate) {
		getEstimates().add(estimate);
		estimate.setContractor(this);

		return estimate;
	}

	public Estimate removeEstimate(Estimate estimate) {
		getEstimates().remove(estimate);
		estimate.setContractor(null);

		return estimate;
	}

}