package martin.controllerservicedao.example.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class PaymentsKey{
	@Column(name = "customerNumber")
	private int customerNumber;
	
	@Column(name = "checkNumber", length = 50)
	private String checkNumber;
}