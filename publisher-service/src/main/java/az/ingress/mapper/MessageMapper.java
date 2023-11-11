package az.ingress.mapper;

import az.ingress.dao.entity.PublisherEntity;
import az.ingress.model.request.PublisherRequest;

public enum MessageMapper {
    MESSAGE_MAPPER;

    public PublisherEntity mapRequestToEntity(PublisherRequest request) {
        return PublisherEntity.builder()
                .name(request.getName())
                .build();
    }
}