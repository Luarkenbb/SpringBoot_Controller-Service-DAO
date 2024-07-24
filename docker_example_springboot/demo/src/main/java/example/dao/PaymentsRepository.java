package example.dao;

import org.springframework.data.repository.CrudRepository;

import example.model.entity.Payments;
import example.model.entity.PaymentsKey;

public interface PaymentsRepository extends CrudRepository<Payments, PaymentsKey>{

}
