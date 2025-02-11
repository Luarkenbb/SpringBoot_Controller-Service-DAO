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
import example.model.request.EmployeesPKRequest;
import example.model.request.OfficesPKRequest;
import example.service.EmployeesService;
import example.utils.ResponseUtils;

@RestController
@RequestMapping("${keycloak.protectedUrl}/employees")
public class EmployeesController {
	private static final Logger logger = LogManager.getLogger(EmployeesController.class);
	
	@Autowired
	private EmployeesService employeesService;
	
	@Syslog
	@RequestValidation
	@PostMapping("/getEmployeeByPK")
	public ResponseEntity<Map<String, Object>> getEmployee(@RequestBody EmployeesPKRequest request){
		logger.info("Start");
		return ResponseUtils.successSingleResult(employeesService.getEmployeeByPK(request));
	}
	
	@Syslog
	@RequestValidation
	@PostMapping("/getEmployeesByOfficeCode")
	public ResponseEntity<Map<String, Object>> getEmployeesByOfficeCode(@RequestBody OfficesPKRequest request){
		logger.info("Start");
		return ResponseUtils.successListResult(employeesService.getEmployeesByOfficeCode(request));
	}
}
