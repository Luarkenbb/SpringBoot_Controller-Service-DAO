package martin.controllerservicedao.example.model.entity;

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
	@Column(name = "productCode", length = 15, nullable = false)
	private String productCode;
	
	@Column(name = "productDescription", nullable = false)
	private String productDescription;
	
	@ManyToOne
	@JoinColumn(name = "productLine")
	private ProductLines productLine;
	
	@Column(name = "productName", length = 70, nullable = false)
	private String productName;
	
	@Column(name = "productScale", length = 10, nullable = false)
	private String productScale;
	
	@Column(name = "productVendor", length = 50, nullable = false)
	private String productVendor;
	
	@Column(name = "buyPrice", length = 10, scale = 2, nullable = false)
	private BigDecimal buyPrice; 
	
	@Column(name = "MSRP", length = 10, scale = 2, nullable = false)
	private BigDecimal MSRP; 
	
	@Column(name = "quantityInStock", nullable = false)
	private short quantityInStock;
}	
