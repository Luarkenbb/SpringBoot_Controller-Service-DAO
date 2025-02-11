package example.dao;

import org.springframework.data.repository.CrudRepository;

import example.model.entity.ProductLines;
import jakarta.transaction.Transactional;

@Transactional
public interface ProductLinesRepository extends CrudRepository<ProductLines, String>{

}
