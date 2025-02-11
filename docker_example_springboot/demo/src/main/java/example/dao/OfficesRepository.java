package example.dao;

import org.springframework.data.repository.CrudRepository;

import example.model.entity.Offices;
import jakarta.transaction.Transactional;

@Transactional
public interface OfficesRepository extends CrudRepository<Offices, String>{

}
