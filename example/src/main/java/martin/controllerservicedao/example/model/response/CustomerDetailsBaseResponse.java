package martin.controllerservicedao.example.model.response;

import lombok.Data;
import martin.controllerservicedao.example.model.vo.CustomerDetailsVO;

@Data
public class CustomerDetailsBaseResponse {
	private int customerNumber;
	private String customerName;
	private String contactLastName;
	private String contactFirstName;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private String salesRepEmployeeNumber;
	private double creditLimit;
	
	public CustomerDetailsBaseResponse() {
		
	}
	
	public CustomerDetailsBaseResponse(CustomerDetailsVO vo) {
		this.customerNumber = vo.getCustomerNumber();
		this.customerName = vo.getCustomerName();
		this.contactLastName = vo.getContactLastName();
		this.contactFirstName = vo.getContactFirstName();
		this.phone = vo.getPhone();
		this.addressLine1 = vo.getAddressLine1();
		this.addressLine2 = vo.getAddressLine2();
		this.city = vo.getCity();
		this.state = vo.getState();
		this.postalCode = vo.getPostalCode();
		this.country = vo.getCountry();
		this.salesRepEmployeeNumber = vo.getSalesRepEmployeeNumber();
		this.creditLimit = vo.getCreditLimit();
	}
}
