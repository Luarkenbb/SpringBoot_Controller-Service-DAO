package martin.controllerservicedao.example.dao;

import org.springframework.data.repository.CrudRepository;

import martin.controllerservicedao.example.model.entity.Payments;
import martin.controllerservicedao.example.model.entity.PaymentsKey;

public interface PaymentsRepository extends CrudRepository<Payments, PaymentsKey>{

}
