package example.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "offices")
public class Offices {
	@Id
	@Column(name = "office_code", length = 10, nullable = false)
	private String officeCode;
	
	@Column(name = "city", length = 50, nullable = false)
	private String city;
	
	@Column(name = "phone", length = 50, nullable = false)
	private String phone;
	
	@Column(name = "address_line1", length = 50, nullable = false)
	private String addressLine1;
	
	@Column(name = "address_line2", length = 50)
	private String addressLine2;
	
	@Column(name = "state", length = 50)
	private String state;
	
	@Column(name = "country", length = 50, nullable = false)
	private String country;
	
	@Column(name = "postal_code", length = 15, nullable = false)
	private String postalCode;
	
	@Column(name = "territory", length = 10, nullable = false)
	private String territory;
}
