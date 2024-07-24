package example.dao;

import org.springframework.data.repository.CrudRepository;

import example.model.entity.Offices;

public interface OfficesRepository extends CrudRepository<Offices, String>{

}
