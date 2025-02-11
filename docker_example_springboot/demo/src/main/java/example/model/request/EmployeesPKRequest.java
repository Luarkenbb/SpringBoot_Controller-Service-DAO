package example.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeesPKRequest {
	@NotNull(message = "Employee number must not be null")
	@Min(value = 0, message = "Employee number must be greater than 0")
	private int employeeNumber;
}
