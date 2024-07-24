package example.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.dao.CustomersRepository;
import example.model.entity.Customers;
import example.model.request.CustomersPKRequest;
import example.model.response.CustomersBaseResponse;

@Service
public class CustomersService {
	private static final Logger logger = LogManager.getLogger(CustomersService.class);
	 
	private CustomersRepository customersRepository;
	
	@Autowired
	public CustomersService(CustomersRepository customersRepository) {
		this.customersRepository = customersRepository;
	}
	
	public CustomersBaseResponse getEmployeeByPK(CustomersPKRequest request) {
		logger.info("Start");
		Optional<Customers> employee = customersRepository.findById(request.getCustomerNumber());
		if(employee.isEmpty()) {
			return new CustomersBaseResponse();
		}
		return new CustomersBaseResponse(employee.get());
	}
}
