package martin.controllerservicedao.example.dao;

import org.springframework.data.repository.CrudRepository;

import martin.controllerservicedao.example.model.entity.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Integer>{

}
