package az.ingress.service.abstraction;

import az.ingress.model.queue.Subscriber;
import az.ingress.model.request.PublisherRequest;

public interface PublisherService {
    void save(PublisherRequest request);
}