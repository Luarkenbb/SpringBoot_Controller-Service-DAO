package martin.controllerservicedao.example.dao;

import org.springframework.data.repository.CrudRepository;

import martin.controllerservicedao.example.model.entity.Employees;

public interface EmployeesRepository extends CrudRepository<Employees, Integer>{

}
