package martin.controllerservicedao.example.model.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CustomersDetailsVO {
	@Id
	@Column(name = "customernumber")
	private int customerNumber;
	
	@Column(name = "customername")
	private String customerName;
	
	@Column(name = "contactlastname")
	private String contactLastName;
	
	@Column(name = "contactfirstname")
	private String contactFirstName;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "addressline1")
	private String addressLine1;
	
	@Column(name = "addressline2")
	private String addressLine2;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "postalcode")
	private String postalCode;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "salesrepemployeenumber")
	private String salesRepEmployeeNumber;
	
	@Column(name = "creditlimit")
	private double creditLimit;
}
