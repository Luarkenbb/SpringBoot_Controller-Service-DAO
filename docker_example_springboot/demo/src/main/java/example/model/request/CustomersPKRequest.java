package example.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomersPKRequest {
	@NotNull(message = "Customer number must not be null")
	@Min(value = 0, message = "Customer number must be greater than 0")
	private int customerNumber; 
}
