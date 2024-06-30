package martin.controllerservicedao.example.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import martin.controllerservicedao.example.dao.PaymentsRepository;
import martin.controllerservicedao.example.dao.ProductsRepository;
import martin.controllerservicedao.example.model.entity.Customers;
import martin.controllerservicedao.example.model.entity.Payments;
import martin.controllerservicedao.example.model.entity.PaymentsKey;
import martin.controllerservicedao.example.model.entity.ProductLines;
import martin.controllerservicedao.example.model.request.PaymentsPKRequest;
import martin.controllerservicedao.example.model.request.ProductLinesPKRequest;
import martin.controllerservicedao.example.model.response.PaymentsBaseResponse;
import martin.controllerservicedao.example.model.response.ProductLinesBaseResponse;

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
