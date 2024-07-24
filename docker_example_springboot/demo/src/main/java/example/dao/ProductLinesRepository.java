package example.dao;

import org.springframework.data.repository.CrudRepository;

import example.model.entity.ProductLines;

public interface ProductLinesRepository extends CrudRepository<ProductLines, String>{

}
