package example.dao;

import org.springframework.data.repository.CrudRepository;

import example.model.entity.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Integer>{

}
