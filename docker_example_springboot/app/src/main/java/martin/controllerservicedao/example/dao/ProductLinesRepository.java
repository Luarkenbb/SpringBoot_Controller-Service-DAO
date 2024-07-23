package martin.controllerservicedao.example.dao;

import org.springframework.data.repository.CrudRepository;

import martin.controllerservicedao.example.model.entity.ProductLines;

public interface ProductLinesRepository extends CrudRepository<ProductLines, String>{

}
