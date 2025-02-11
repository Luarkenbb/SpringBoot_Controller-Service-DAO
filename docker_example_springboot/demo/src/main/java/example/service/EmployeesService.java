package example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.dao.EmployeesRepository;
import example.model.entity.Employees;
import example.model.request.EmployeesPKRequest;
import example.model.request.OfficesPKRequest;
import example.model.response.EmployeesBaseResponse;

@Service
public class EmployeesService {
	private static final Logger logger = LogManager.getLogger(EmployeesService.class);
	
	private final EmployeesRepository employeesRepository;
	
	@Autowired
	public EmployeesService (EmployeesRepository employeesRepository) {
		this.employeesRepository = employeesRepository;
	}
	
	public EmployeesBaseResponse getEmployeeByPK(EmployeesPKRequest request) {
		logger.info("Start");
		Optional<Employees> employee = employeesRepository.findById(request.getEmployeeNumber());
		if(employee.isEmpty()) {
			return null;
		}
		return new EmployeesBaseResponse(employee.get());
	}
	
	public List<EmployeesBaseResponse> getEmployeesByOfficeCode(OfficesPKRequest request) {
		 logger.info("Start");
		 List<EmployeesBaseResponse> response = new ArrayList<EmployeesBaseResponse>();
		 List<Employees> employees = employeesRepository.findByOfficeCode(request.getOfficeCode());
		 
		 if(employees == null || employees.isEmpty()) {
			 return null;
		 }
		 
		 for (Employees employee : employees) {
			 response.add(new EmployeesBaseResponse(employee));
		 }
		 return response;
	}
}
