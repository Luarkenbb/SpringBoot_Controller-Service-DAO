package martin.controllerservicedao.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import martin.controllerservicedao.example.model.request.CustomerGetCustomerDetailRequest;
import martin.controllerservicedao.example.model.response.CustomerGetCustomerDetailResponse;

@Service
public class CustomerService {
	private static final Logger logger = LogManager.getLogger(CustomerService.class);
	
	public CustomerGetCustomerDetailResponse getCustomerDetails(CustomerGetCustomerDetailRequest request) throws Exception{
		
		
		return null;
	}
}
