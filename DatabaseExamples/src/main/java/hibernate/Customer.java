package hibernate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="contact_lastname")
	private String contactLastName;
	
	@Column(name="contact_firstname")
	private String contactFirstName;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="address_line1")
	private String addressLine1;
	
	@Column(name="address_line2")
	private String addressLine2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="postal_code")
	private String postalCode;
	
	@Column(name="country")
	private String country;
	
	@Column(name="salesRepEmployeeNumber", insertable=false, updatable=false)		// This will fix 'repeated column mapping' error
	private Integer salesRepEmployeeNumber;
	
	@Column(name="credit_limit", columnDefinition="decimal", precision=10, scale=2)
	private Double creditLimit;

	
	
	/* To Employee */
	@ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "salesRepEmployeeNumber", nullable = true)
    private Employee employee;
	
	/* To Payment */
	// Map 1 to many relationship from customer to payments
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Payment> payments;
	
	
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", contactLastName=" + contactLastName
				+ ", contactFirstName=" + contactFirstName + ", phone=" + phone + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", postalCode="
				+ postalCode + ", country=" + country + ", salesRepEmployeeNumber=" + salesRepEmployeeNumber
				+ ", creditLimit=" + creditLimit + "]";
	}


	
	

	
	
	
	
	
	
}
