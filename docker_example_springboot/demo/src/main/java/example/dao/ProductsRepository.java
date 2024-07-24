package example.dao;

import org.springframework.data.repository.CrudRepository;

import example.model.entity.Products;

public interface ProductsRepository extends CrudRepository<Products, String>{

}
