package example.dao;

import org.springframework.data.repository.CrudRepository;

import example.model.entity.Customers;
import jakarta.transaction.Transactional;

@Transactional
public interface CustomersRepository extends CrudRepository<Customers, Integer>{

}
