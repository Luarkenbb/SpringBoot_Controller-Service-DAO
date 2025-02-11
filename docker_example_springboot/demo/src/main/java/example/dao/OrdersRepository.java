package example.dao;

import org.springframework.data.repository.CrudRepository;

import example.model.entity.Orders;
import jakarta.transaction.Transactional;

@Transactional
public interface OrdersRepository extends CrudRepository<Orders, Integer>{

}
