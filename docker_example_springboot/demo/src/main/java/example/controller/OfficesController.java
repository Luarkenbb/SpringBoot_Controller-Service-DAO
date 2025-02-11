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
import example.model.request.OfficesPKRequest;
import example.service.OfficesService;
import example.utils.ResponseUtils;

@RestController
@RequestMapping("${keycloak.protectedUrl}/offices")
public class OfficesController {
	private static final Logger logger = LogManager.getLogger(OfficesController.class);
	
	@Autowired
	private OfficesService officesService;
	
	@Syslog
	@RequestValidation
	@PostMapping("/getOfficesByPK")
	public ResponseEntity<Map<String, Object>> getOffice(@RequestBody OfficesPKRequest request){
		logger.info("Start");
		return ResponseUtils.successSingleResult(officesService.getOfficeByPK(request));
	}
}
