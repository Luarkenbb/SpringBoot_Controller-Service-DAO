package example.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customers {
	public Customers() {
		
	}
	
	public Customers(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	
	@Column(name = "address_line1", length = 50, nullable = false)
	private String addressLine1;
	
	@Column(name = "address_line2", length = 50)
	private String addressLine2;
	
	@Column(name = "city", length = 50,  nullable = false)
	private String city;
	
	@Column(name = "contact_first_name", length = 50, nullable = false)
	private String contactFirstName;
	
	@Column(name = "contact_last_name", length = 50, nullable = false)
	private String contactLastName;
	
	@Column(name = "country", length = 50, nullable = false)
	private String country;
	
	@Column(name = "credit_limit", length = 10, scale = 2)
	private BigDecimal creditLimit;
	
	@Column(name = "customer_name", length = 50, nullable = false)
	private String customerName;
	
	@Id
	@Column(name = "customer_number", nullable = false)
	private int customerNumber;
	
	@Column(name = "phone", length = 50, nullable = false)
	private String phone;
	
	@Column(name = "postal_code", length = 15)
	private String postalCode;
	
	@ManyToOne
	@JoinColumn(name = "sales_rep_employee_number")
	private Employees salesRepEmployeeNumber;
	
	@Column(name = "state", length = 50)
	private String state;

}
