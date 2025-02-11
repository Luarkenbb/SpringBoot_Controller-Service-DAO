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
	
	private final ProductsRepository productsRepository;
	
	@Autowired
	public ProductsService(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}
	
	public ProductsBaseResponse getProductsByPK(ProductsPKRequest request){
		Optional<Products> product = productsRepository.findById(request.getProductCode());
		if(!product.isPresent()) {
			return null;
		}	
		return new ProductsBaseResponse(product.get());
	}
}
