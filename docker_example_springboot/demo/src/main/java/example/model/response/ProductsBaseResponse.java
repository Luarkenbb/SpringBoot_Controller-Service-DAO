package example.model.response;

import java.math.BigDecimal;

import example.model.entity.Products;
import lombok.Data;

@Data
public class ProductsBaseResponse {
	private String productCode;
	private String productDescription;
	private String productLine;
	private String productName;
	private String productScale;
	private String productVendor;
	private short quantityInStock;
	private BigDecimal buyPrice;
	private BigDecimal MSRP;
	
	public ProductsBaseResponse() {
		
	}
	
	public ProductsBaseResponse(Products entity) {
		this.productCode = entity.getProductCode();
		this.productDescription = entity.getProductDescription();
		this.productLine = entity.getProductLine().getProductLine();
		this.productName = entity.getProductName();
		this.productScale = entity.getProductScale();
		this.productVendor = entity.getProductVendor();
		this.quantityInStock = entity.getQuantityInStock();
		this.buyPrice = entity.getBuyPrice();
		this.MSRP = entity.getMSRP();
	}
}
