package example.model.entity;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "productlines")
public class ProductLines {
	
	@Id
	@Column(name = "product_line", length = 50, nullable = false)
	private String productLine;
	
	@Column(name = "text_description", length = 4000)
	private String textDescription;
	
	@Column(name = "html_description", columnDefinition = "mediumtext")
	private String htmlDescription;
	
	@Column(name = "image", columnDefinition = "mediumblob")
	private Blob image;
}
