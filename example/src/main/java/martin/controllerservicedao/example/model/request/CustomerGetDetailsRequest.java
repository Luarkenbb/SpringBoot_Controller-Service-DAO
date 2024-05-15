package martin.controllerservicedao.example.model.request;

import lombok.Data;

@Data
public class CustomerGetDetailsRequest {
	private String customerName;
	private String contactLastName;
	private String contactFirstName;
	private String phone;
	private String city;
	private String country;
	private double creditLimit;
}
