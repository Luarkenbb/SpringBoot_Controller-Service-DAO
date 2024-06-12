package martin.controllerservicedao.example.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import martin.controllerservicedao.example.dao.CustomersRepository;
import martin.controllerservicedao.example.model.entity.Customers;
import martin.controllerservicedao.example.model.entity.Employees;
import martin.controllerservicedao.example.model.request.CustomersPKRequest;
import martin.controllerservicedao.example.model.request.EmployeesPKRequest;
import martin.controllerservicedao.example.model.response.CustomersBaseResponse;
import martin.controllerservicedao.example.model.response.EmployeesBaseResponse;

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
