package martin.controllerservicedao.example.model.entity;

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
@Table(name = "Customers")
public class Customers {
	@Column(name = "addressLine1", length = 50, nullable = false)
	private String addressLine1;
	
	@Column(name = "addressLine2", length = 50)
	private String addressLine2;
	
	@Column(name = "city", length = 50,  nullable = false)
	private String city;
	
	@Column(name = "contactFirstName", length = 50, nullable = false)
	private String contactFirstName;
	
	@Column(name = "contactLastName", length = 50, nullable = false)
	private String contactLastName;
	
	@Column(name = "country", length = 50, nullable = false)
	private String country;
	
	@Column(name = "creditLimit", length = 10, scale = 2)
	private BigDecimal creditLimit;
	
	@Column(name = "customerName", length = 50, nullable = false)
	private String customerName;
	
	@Id
	@Column(name = "customerNumber", nullable = false)
	private int customerNumber;
	
	@Column(name = "phone", length = 50, nullable = false)
	private String phone;
	
	@Column(name = "postalCode", length = 15)
	private String postalCode;
	
	@ManyToOne
	@JoinColumn(name = "salesRepEmployeeNumber")
	private Employees salesRepEmployeeNumber;
	
	@Column(name = "state", length = 50)
	private String state;
	
}
