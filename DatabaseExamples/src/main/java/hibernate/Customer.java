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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
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
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "salesRepEmployeeNumber", nullable = true)
    private Employee employee;
	
	/* To Payment */
	@ToString.Exclude
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Payment> payments;
	
	/* To Order */
	@LazyCollection(LazyCollectionOption.FALSE)
	@ToString.Exclude
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> orders;
	
	
	
	
}
