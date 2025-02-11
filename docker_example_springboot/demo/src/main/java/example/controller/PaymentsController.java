package example.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.annotation.annotations.RequestValidation;
import example.annotation.annotations.Syslog;
import example.model.request.PaymentsPKRequest;
import example.service.PaymentsService;
import example.utils.ResponseUtils;

@RestController
@RequestMapping("${keycloak.protectedUrl}/payments")
public class PaymentsController {
	private static final Logger logger = LogManager.getLogger(PaymentsController.class);
		
	@Autowired
	private PaymentsService paymentsService;
	
	@Syslog
	@RequestValidation
	@PostMapping("/getPaymentsByPK")
	public ResponseEntity<Map<String, Object>> getPayment(@RequestBody PaymentsPKRequest request){
		logger.info("Start");
		return ResponseUtils.successSingleResult(paymentsService.getPaymentsByPK(request));
	}
}
