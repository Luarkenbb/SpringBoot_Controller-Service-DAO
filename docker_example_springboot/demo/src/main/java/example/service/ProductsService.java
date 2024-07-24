package example.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.dao.ProductsRepository;
import example.model.entity.Products;
import example.model.request.ProductsPKRequest;
import example.model.response.ProductsBaseResponse;

@Service
public class ProductsService {
	private static final Logger logger = LogManager.getLogger(ProductsService.class);
	
	private ProductsRepository productsRepository;
	
	@Autowired
	public ProductsService(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}
	
	public ProductsBaseResponse getProductsByPK(ProductsPKRequest request){
		logger.info("Start");
		Optional<Products> product = productsRepository.findById(request.getProductCode());
		try {
			if(!product.isEmpty()) {
				return new ProductsBaseResponse(product.get());
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}	
		return new ProductsBaseResponse();
	}
}
