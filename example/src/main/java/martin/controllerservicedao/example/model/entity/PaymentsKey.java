package martin.controllerservicedao.example.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class PaymentsKey{
	@Column(name = "customerNumber", nullable = false)
	private Customers customerNumber;
	
	@Column(name = "checkNumber", length = 50, nullable = false)
	private String checkNumber;
}