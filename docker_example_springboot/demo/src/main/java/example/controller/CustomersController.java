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
import example.model.request.CustomersPKRequest;
import example.service.CustomersService;
import example.utils.ResponseUtils;

@RestController
@RequestMapping("${keycloak.protectedUrl}/customers")
public class CustomersController {
	private static final Logger logger = LogManager.getLogger(CustomersController.class);
	
	@Autowired
	private CustomersService customersService;
	
	@Syslog
	@RequestValidation
	@PostMapping("/getCustomersByPK")
	public ResponseEntity<Map<String, Object>> getCustomer(@RequestBody CustomersPKRequest request){
		logger.info("Start");
		return ResponseUtils.successSingleResult(customersService.getCustomerByPK(request));
	}
}
