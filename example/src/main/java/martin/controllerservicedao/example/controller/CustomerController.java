package martin.controllerservicedao.example.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import martin.controllerservicedao.example.model.request.CustomerGetCustomerDetailRequest;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	private static final Logger logger = LogManager.getLogger(CustomerController.class);
	
	
	
	@PostMapping("/get-customer-detail")
	public ResponseEntity<Map<String, Object>> getCustomerDetail(@RequestBody CustomerGetCustomerDetailRequest request){
		logger.info("get-customer-detail start");
		
		logger.info("get-customer-detail end");
		return null;
	}
	
}
