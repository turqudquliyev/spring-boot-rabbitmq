package az.ingress.mapper;

import az.ingress.dao.entity.SubscriberEntity;
import az.ingress.model.queue.Subscriber;

public enum SubscriberMapper {
    SUBSCRIBER_MAPPER;

    public SubscriberEntity mapRequestToEntity(Subscriber subscriber) {
        return SubscriberEntity.builder()
                .name(subscriber.getParameter())
                .build();
    }
}
