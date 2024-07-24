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

import example.model.request.ProductLinesPKRequest;
import example.service.ProductLinesService;
import example.utils.ResponseUtils;

@RestController
@RequestMapping("/productLines")
public class ProductLinesController {
	private static final Logger logger = LogManager.getLogger(ProductLinesController.class);
	
	@Autowired
	private ProductLinesService productLinesService;
	
	@PostMapping("/getProductLinesByPK")
	public ResponseEntity<Map<String, Object>> getProductLine(@RequestBody ProductLinesPKRequest request){
		logger.info("Start");
		return ResponseUtils.successSingleResult(productLinesService.getProductLinesByPK(request));
	}
}
