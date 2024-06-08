package martin.controllerservicedao.example.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import martin.controllerservicedao.example.model.request.CustomersPKRequest;
import martin.controllerservicedao.example.model.request.CustomersGetDetailsRequest;
import martin.controllerservicedao.example.model.response.CustomersDetailsBaseResponse;
import martin.controllerservicedao.example.service.CustomersService;
import martin.controllerservicedao.example.utils.ResponseUtils;

@RestController
@RequestMapping("/customer")
public class CustomersController {
	private static final Logger logger = LogManager.getLogger(CustomersController.class);
	
	@Autowired
	private CustomersService customerService;
	
	@PostMapping("/get-customer-details-by-PK")
	public ResponseEntity<Map<String, Object>> getCustomerDetailsByPK(@RequestBody CustomersPKRequest request){
		logger.info("get-customer-details-by-PK start");
		CustomersDetailsBaseResponse response;
		
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
	public ResponseEntity<Map<String, Object>> getCustomerDetails(@RequestBody CustomersGetDetailsRequest request){
		logger.info("get-customer-details start");
		List<CustomersDetailsBaseResponse> response;
		
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
