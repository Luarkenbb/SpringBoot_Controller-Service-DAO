package martin.controllerservicedao.example.model.entity;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "productLines")
public class ProductLines {
	
	@Id
	@Column(name = "productLine", length = 50, nullable = false)
	private String productLine;
	
	@Column(name = "textDescription", length = 4000)
	private String textDescription;
	
	@Column(name = "htmlDescription", columnDefinition = "mediumtext")
	private String htmlDescription;
	
	@Column(name = "image", columnDefinition = "mediumblob")
	private Blob image;
}
