package martin.controllerservicedao.example.dao;

import org.springframework.data.repository.CrudRepository;

import martin.controllerservicedao.example.model.entity.Products;

public interface ProductsRepository extends CrudRepository<Products, String>{

}
