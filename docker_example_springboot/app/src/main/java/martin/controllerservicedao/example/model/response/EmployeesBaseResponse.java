package martin.controllerservicedao.example.model.response;

import lombok.Data;
import martin.controllerservicedao.example.model.entity.Employees;

@Data
public class EmployeesBaseResponse {
	private int employeeNumber;
	private String lastName;
	private String firstName;
	private String extension;
	private String email;
	private String officeCode;
	private int reportsTo;
	private String jobTitle;
	
	
	public EmployeesBaseResponse() {
		
	}
	
	public EmployeesBaseResponse(Employees entity) {
		this.employeeNumber = entity.getEmployeeNumber();
		this.lastName = entity.getLastName();
		this.firstName = entity.getFirstName();
		this.extension = entity.getExtension();
		this.email = entity.getEmail();
		this.officeCode = entity.getOfficeCode().getOfficeCode();
		
		if(entity.getReportsTo() != null) {
			this.reportsTo = entity.getReportsTo().getEmployeeNumber();
		}
		
		this.jobTitle = entity.getJobTitle();
	}
}
