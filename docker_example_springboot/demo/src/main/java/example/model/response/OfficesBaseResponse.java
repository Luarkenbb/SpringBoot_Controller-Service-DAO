package example.model.response;

import org.apache.commons.lang3.StringUtils;

import example.model.entity.Offices;
import lombok.Data;

@Data
public class OfficesBaseResponse {
	private String officeCode;
	private String city;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String state;
	private String country;
	private String postalCode;
	private String territory;
	
	public OfficesBaseResponse() {
		
	}
	
	public OfficesBaseResponse(Offices entity) {
		this.officeCode = entity.getOfficeCode();
		this.city = entity.getCity();
		this.phone = entity.getPhone();
		this.addressLine1 = entity.getAddressLine1();
		this.addressLine2 = StringUtils.isNotEmpty(entity.getAddressLine2()) ? entity.getAddressLine2() : "";
		this.state = StringUtils.isNotEmpty(entity.getState()) ? entity.getState() : "";
		this.country = entity.getCountry();
		this.postalCode = entity.getPostalCode();
		this.territory = entity.getTerritory();
	}
}
