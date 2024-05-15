package martin.controllerservicedao.example.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import martin.controllerservicedao.example.model.request.CustomerGetCustomerDetailRequest;
import martin.controllerservicedao.example.model.response.CustomerGetCustomerDetailResponse;
import martin.controllerservicedao.example.service.CustomerService;
import martin.controllerservicedao.example.utils.ResponseUtils;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	private static final Logger logger = LogManager.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/get-customer-detail")
	public ResponseEntity<Map<String, Object>> getCustomerDetail(@RequestBody CustomerGetCustomerDetailRequest request){
		logger.info("get-customer-detail start");
		CustomerGetCustomerDetailResponse response;
		
		try {
			 response = customerService.getCustomerDetails(request);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return null;
		}
		
		logger.info("get-customer-detail end");
		return ResponseUtils.successSingleResult(response);
	}	
}
