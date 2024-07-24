package example.dao;

import org.springframework.data.repository.CrudRepository;

import example.model.entity.Customers;

public interface CustomersRepository extends CrudRepository<Customers, Integer>{

}
