package hibernate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="office_id")
	private Integer officeId;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="extension")
	private String extension;
	
	@Column(name="email")
	private String email;
	
	@Column(name="reports_to")
	private Integer reportsTo;
	
	@Column(name="job_title")
	private String jobTitle;
	
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomer(List<Customer> customer) {
		this.customers = customer;
	}

	@Column(name="vacation_hours")
	private Integer vacationHours;
	
	// Map 1 to many relationship from employee to customer
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Customer> customers;
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", officeId=" + officeId + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", extension=" + extension + ", email=" + email + ", reportsTo=" + reportsTo + ", jobTitle="
				+ jobTitle + ", vacationHours=" + vacationHours + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(Integer reportsTo) {
		this.reportsTo = reportsTo;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Integer getVacationHours() {
		return vacationHours;
	}

	public void setVacationHours(Integer vacationHours) {
		this.vacationHours = vacationHours;
	}
	
	
}
