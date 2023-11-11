package az.ingress.dao.repository;

import az.ingress.dao.entity.SubscriberEntity;
import org.springframework.data.repository.CrudRepository;

public interface SubscriberRepository extends CrudRepository<SubscriberEntity, String> {
}