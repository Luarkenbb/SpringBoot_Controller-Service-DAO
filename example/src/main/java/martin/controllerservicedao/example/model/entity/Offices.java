package martin.controllerservicedao.example.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Offices")
public class Offices {
	@Id
	@Column(name = "officeCode", length = 10, nullable = false)
	private String officeCode;
	
	@Column(name = "city", length = 50, nullable = false)
	private String city;
	
	@Column(name = "phone", length = 50, nullable = false)
	private String phone;
	
	@Column(name = "addressLine1", length = 50, nullable = false)
	private String addressLine1;
	
	@Column(name = "addressLine2", length = 50)
	private String addressLine2;
	
	@Column(name = "state", length = 50)
	private String state;
	
	@Column(name = "country", length = 50, nullable = false)
	private String country;
	
	@Column(name = "postalCode", length = 15, nullable = false)
	private String postalCode;
	
	@Column(name = "territory", length = 10, nullable = false)
	private String territory;
}
