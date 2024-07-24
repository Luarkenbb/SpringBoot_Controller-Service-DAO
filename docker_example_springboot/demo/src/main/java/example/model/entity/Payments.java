package example.model.entity;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Payments")
public class Payments { 
	//composite primary key
	@EmbeddedId
	private PaymentsKey paymentsKey;
	
	@Column(name = "paymentDate", nullable = false)
	private Date paymentDate;
	
	@Column(name = "amount", length = 10, scale = 2, nullable = false)
	private BigDecimal amount;
}
