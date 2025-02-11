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
import example.model.request.ProductsPKRequest;
import example.service.ProductsService;
import example.utils.ResponseUtils;

@RestController
@RequestMapping("${keycloak.protectedUrl}/products")
public class ProductsController {
private static final Logger logger = LogManager.getLogger(ProductsController.class);
	
	@Autowired
	private ProductsService productsService;
	
	@Syslog
	@RequestValidation
	@PostMapping("/getProductsByPK")
	public ResponseEntity<Map<String, Object>> getProductLine(@RequestBody ProductsPKRequest request){
		logger.info("Start");
		return ResponseUtils.successSingleResult(productsService.getProductsByPK(request));
	}
}
