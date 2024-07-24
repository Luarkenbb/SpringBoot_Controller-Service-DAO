package example.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.dao.PaymentsRepository;
import example.model.entity.Customers;
import example.model.entity.Payments;
import example.model.entity.PaymentsKey;
import example.model.request.PaymentsPKRequest;
import example.model.response.PaymentsBaseResponse;

@Service
public class PaymentsService {
private static final Logger logger = LogManager.getLogger(PaymentsService.class);
	
	private final PaymentsRepository paymentsRepository;
	
	@Autowired
	public PaymentsService(PaymentsRepository paymentsRepository) {
		this.paymentsRepository = paymentsRepository;
	}
	
	public PaymentsBaseResponse getPaymentsByPK(PaymentsPKRequest request){
		logger.info("Start");
		
		PaymentsKey paymentKey;
		paymentKey = new PaymentsKey();
		paymentKey.setCheckNumber(request.getCheckNumber());
		paymentKey.setCustomerNumber(new Customers(request.getCustomerNumber()));
		
		
		Optional<Payments> payments = paymentsRepository.findById(paymentKey);
		try {
			if(!payments.isEmpty()) {
				return new PaymentsBaseResponse(payments.get());
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}	
		
		return new PaymentsBaseResponse();
	}
}
