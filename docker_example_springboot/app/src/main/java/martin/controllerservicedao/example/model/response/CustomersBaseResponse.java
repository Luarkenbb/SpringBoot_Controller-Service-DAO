package martin.controllerservicedao.example.model.response;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;
import martin.controllerservicedao.example.model.entity.Customers;

@Data
public class CustomersBaseResponse {
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String contactFirstName;
	private String contactLastName;
	private String country;
	private BigDecimal creditLimit;
	private String customerName;
	private int customerNumber;
	private String phone;
	private String postalCode;
	private int salesRepEmployeeNumber;
	private String state;
	
	public CustomersBaseResponse() {
		
	}
	
	public CustomersBaseResponse(Customers entity) {
		this.addressLine1 = entity.getAddressLine1();
		this.addressLine2 = StringUtils.isNotEmpty(entity.getAddressLine2()) ? entity.getAddressLine2() : null;
		this.city = entity.getCity();
		this.contactFirstName = entity.getContactFirstName();
		this.contactLastName = entity.getContactLastName();
		this.country = entity.getCountry();
		
		this.creditLimit = entity.getCreditLimit();
		
		this.customerName = entity.getCustomerName();
		this.customerNumber = entity.getCustomerNumber();
		this.phone = entity.getPhone();
		this.postalCode = StringUtils.isNotEmpty(entity.getPostalCode()) ? entity.getPostalCode() : null;
		this.salesRepEmployeeNumber = entity.getSalesRepEmployeeNumber() != null ? entity.getSalesRepEmployeeNumber().getEmployeeNumber() : 0;
		this.state = StringUtils.isNotEmpty(entity.getState()) ? entity.getState() : null;
	}
}
