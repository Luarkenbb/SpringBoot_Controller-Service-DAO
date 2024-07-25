package example.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Embeddable
@Data
public class PaymentsKey{
	@ManyToOne
	@JoinColumn(name = "customer_number", nullable = false)
	private Customers customerNumber;
	
	@Column(name = "check_number", length = 50, nullable = false)
	private String checkNumber;
}