package martin.controllerservicedao.example.controller;

import java.util.ArrayList;
import java.util.List;
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

import martin.controllerservicedao.example.model.request.CustomerDetailsBaseRequest;
import martin.controllerservicedao.example.model.response.CustomerDetailsBaseResponse;
import martin.controllerservicedao.example.service.CustomerService;
import martin.controllerservicedao.example.utils.ResponseUtils;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	private static final Logger logger = LogManager.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/get-customer-details-by-PK")
	public ResponseEntity<Map<String, Object>> getCustomerDetailsByPK(@RequestBody CustomerDetailsBaseRequest request){
		logger.info("get-customer-details-by-PK start");
		CustomerDetailsBaseResponse response;
		
		try {
			 response = customerService.getCustomerDetailsByPK(request);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return null;
		}
		
		logger.info("get-customer-details-by-PK end");
		return ResponseUtils.successSingleResult(response);
	}
	
	@PostMapping("/get-customer-details")
	public ResponseEntity<Map<String, Object>> getCustomerDetails(@RequestBody CustomerDetailsBaseRequest request){
		logger.info("get-customer-details start");
		List<CustomerDetailsBaseResponse> response;
		
		try {
			response = customerService.getCustomerDetails(request);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return null;
		}
		
		logger.info("get-customer-details end");
		return ResponseUtils.successListResult(response);
	}
	
}
