package example.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Employees")
public class Employees {
	@Id
	@Column(name = "employeeNumber", nullable = false)
	private int employeeNumber;
	
	@Column(name = "lastName", length = 50, nullable = false)
	private String lastName;
	
	@Column(name = "firstName", length = 50, nullable = false)
	private String firstName;
	
	@Column(name = "extension", length = 10, nullable = false)
	private String extension;
	
	@Column(name = "email", length = 100, nullable = false)
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "officeCode", nullable = false)
	private Offices officeCode;
	
	@ManyToOne
	@JoinColumn(name = "reportsTo")
	private Employees reportsTo;
	
	@Column(name = "jobTitle", length = 50, nullable = false)
	private String jobTitle;
}
