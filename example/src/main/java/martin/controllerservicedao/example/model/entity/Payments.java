package martin.controllerservicedao.example.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
	
	@Column(name = "paymentDate")
	private Date paymentDate;
	
	@Column(name = "amount", length = 10, scale = 2)
	private BigDecimal amount;
}
