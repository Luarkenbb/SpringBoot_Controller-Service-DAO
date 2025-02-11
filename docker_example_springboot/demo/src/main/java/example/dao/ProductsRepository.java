package example.dao;

import org.springframework.data.repository.CrudRepository;

import example.model.entity.Products;
import jakarta.transaction.Transactional;

@Transactional
public interface ProductsRepository extends CrudRepository<Products, String>{

}
