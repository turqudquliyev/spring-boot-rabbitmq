package az.ingress.dao.repository;

import az.ingress.dao.entity.PublisherEntity;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<PublisherEntity, String> {
}