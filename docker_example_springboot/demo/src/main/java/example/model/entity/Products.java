package example.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Products {
	@Id
	@Column(name = "product_code", length = 15, nullable = false)
	private String productCode;
	
	@Column(name = "product_description", nullable = false)
	private String productDescription;
	
	@ManyToOne
	@JoinColumn(name = "product_line")
	private ProductLines productLine;
	
	@Column(name = "product_name", length = 70, nullable = false)
	private String productName;
	
	@Column(name = "product_scale", length = 10, nullable = false)
	private String productScale;
	
	@Column(name = "product_vendor", length = 50, nullable = false)
	private String productVendor;
	
	@Column(name = "buy_price", length = 10, scale = 2, nullable = false)
	private BigDecimal buyPrice; 
	
	@Column(name = "MSRP", length = 10, scale = 2, nullable = false)
	private BigDecimal MSRP; 
	
	@Column(name = "quantity_in_stock", nullable = false)
	private short quantityInStock;
}	
