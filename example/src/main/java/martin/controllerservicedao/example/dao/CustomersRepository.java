package martin.controllerservicedao.example.dao;

import org.springframework.data.repository.CrudRepository;

import martin.controllerservicedao.example.model.entity.Customers;

public interface CustomersRepository extends CrudRepository<Customers, Integer>{

}
