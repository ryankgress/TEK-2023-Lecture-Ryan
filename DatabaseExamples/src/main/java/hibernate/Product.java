package hibernate;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="product_code")
	private String productCode;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="productline_id", insertable=false, updatable=false)
	private Integer productLineId;
	
	@Column(name="product_scale")
	private String productScale;
	
	@Column(name="product_vendor")
	private String productVendor;
	
	@Column(name="product_description", columnDefinition = "TEXT")
	private String productDescription;
	
	@Column(name="quantity_in_stock", columnDefinition="smallint")
	private Integer quantityInStock;
	
	@Column(name="buy_price", columnDefinition="decimal", precision=10, scale=2)
	private Double buyPrice;
	
	@Column(name="msrp", columnDefinition="decimal", precision=10, scale=2)
	private Double msrp;
	
	/* To OrderDetails */
	@LazyCollection(LazyCollectionOption.FALSE)
	@ToString.Exclude
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetails;
	
}
