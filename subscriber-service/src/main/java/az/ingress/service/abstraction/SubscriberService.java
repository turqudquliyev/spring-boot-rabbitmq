package az.ingress.service.abstraction;

import az.ingress.model.queue.Subscriber;

public interface SubscriberService {
    void save(Subscriber subscriber);
}