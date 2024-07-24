package example.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.dao.ProductLinesRepository;
import example.model.entity.ProductLines;
import example.model.request.ProductLinesPKRequest;
import example.model.response.ProductLinesBaseResponse;

@Service
public class ProductLinesService {
	private static final Logger logger = LogManager.getLogger(ProductLinesService.class);
	
	private ProductLinesRepository productLinesRepository;
	
	@Autowired
	public ProductLinesService(ProductLinesRepository productLinesRepository) {
		this.productLinesRepository = productLinesRepository;
	}
	
	public ProductLinesBaseResponse getProductLinesByPK(ProductLinesPKRequest request){
		logger.info("Start");
		Optional<ProductLines> productLine = productLinesRepository.findById(request.getProductLine());
		try {
			if(!productLine.isEmpty()) {
				return new ProductLinesBaseResponse(productLine.get());
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}	
		return new ProductLinesBaseResponse();
	}
}
