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
@Table(name = "employees")
public class Employees {
	@Id
	@Column(name = "employee_number", nullable = false)
	private int employeeNumber;
	
	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;
	
	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;
	
	@Column(name = "extension", length = 10, nullable = false)
	private String extension;
	
	@Column(name = "email", length = 100, nullable = false)
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "office_code", nullable = false)
	private Offices officeCode;
	
	@ManyToOne
	@JoinColumn(name = "reports_to")
	private Employees reportsTo;
	
	@Column(name = "job_title", length = 50, nullable = false)
	private String jobTitle;
}
