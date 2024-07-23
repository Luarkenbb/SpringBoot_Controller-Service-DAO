package martin.controllerservicedao.example.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import martin.controllerservicedao.example.model.entity.Employees;

public interface EmployeesRepository extends CrudRepository<Employees, Integer>{
	@Query("SELECT e FROM Employees e WHERE e.officeCode.officeCode = ?1")
	List<Employees> findByOfficeCode(String officeCode);
}
