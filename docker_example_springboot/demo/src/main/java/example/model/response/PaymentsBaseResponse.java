package example.model.response;

import java.math.BigDecimal;
import java.sql.Date;

import example.model.entity.Payments;
import lombok.Data;

@Data
public class PaymentsBaseResponse {
	private int customerNumber;
	private String checkNumber;
	private Date paymentDate;
	private BigDecimal amount;
	
	public PaymentsBaseResponse(){
		
	}
	
	public PaymentsBaseResponse(Payments entity) {
		this.customerNumber = entity.getPaymentsKey().getCustomerNumber().getCustomerNumber();
		this.checkNumber = entity.getPaymentsKey().getCheckNumber();
		this.paymentDate = entity.getPaymentDate();
		this.amount = entity.getAmount();
	}
}
