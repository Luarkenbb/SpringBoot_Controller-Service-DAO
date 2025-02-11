package example.model.request;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class PaymentsPKRequest {
	@Min(value = 0, message = "Customer number must be greater than 0")
	private int customerNumber;
	private String checkNumber;
	
}
