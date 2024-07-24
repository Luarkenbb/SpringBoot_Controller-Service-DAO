package example.model.response;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;

import example.model.entity.ProductLines;
import lombok.Data;

@Data
public class ProductLinesBaseResponse {
	private String productLine;
	private String textDescription;
	private String htmlDescription;
	private byte[] image;
	
	public ProductLinesBaseResponse() {
		
	}
	
	public ProductLinesBaseResponse(ProductLines entity) throws IOException, SQLException {
		this.productLine = entity.getProductLine();
		this.textDescription = StringUtils.isNotEmpty(entity.getHtmlDescription()) ? entity.getTextDescription() : null;
		this.htmlDescription = StringUtils.isNotEmpty(entity.getHtmlDescription()) ? entity.getHtmlDescription() : null;
		this.image = entity.getImage() != null ? entity.getImage().getBinaryStream().readAllBytes() : null;
	}
}
