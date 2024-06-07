package martin.controllerservicedao.example.dao;

import org.springframework.data.repository.CrudRepository;

import martin.controllerservicedao.example.model.entity.Offices;

public interface OfficesRepository extends CrudRepository<Offices, String>{

}
