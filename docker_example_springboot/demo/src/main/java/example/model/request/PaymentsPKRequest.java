package example.model.request;

import lombok.Data;

@Data
public class PaymentsPKRequest {
	private int customerNumber;
	private String checkNumber;
	
}
