package hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;			// Used java.sql.Date
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "payments")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="customer_id", insertable=false, updatable=false)
	private Integer customerId;
	
	@Column(name="check_number")
	private String checkNumber;
	
	@Column(name="payment_date")		// Date here
	private Date paymentDate;
	
	@Column(name="amount", columnDefinition="decimal", precision=10, scale=2)
	private Double amount;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

	@Override
	public String toString() {
		return "Payment [id=" + id + ", customerId=" + customerId + ", checkNumber=" + checkNumber + ", paymentDate="
				+ paymentDate + ", amount=" + amount +  "]";
	}


	
	
	
	
	
	
}
