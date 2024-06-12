package martin.controllerservicedao.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import martin.controllerservicedao.example.dao.CustomersRepository;

@Service
public class CustomersService {
	private static final Logger logger = LogManager.getLogger(CustomersService.class);
	 
	private CustomersRepository customersRepository;
	
	@Autowired
	public CustomersService(CustomersRepository customersRepository) {
		this.customersRepository = customersRepository;
	}
	
	
}
