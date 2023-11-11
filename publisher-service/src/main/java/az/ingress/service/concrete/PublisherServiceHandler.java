package az.ingress.service.concrete;

import az.ingress.aop.annotation.Log;
import az.ingress.dao.repository.PublisherRepository;
import az.ingress.model.queue.Subscriber;
import az.ingress.model.request.PublisherRequest;
import az.ingress.queue.abstraction.MessagePublisher;
import az.ingress.service.abstraction.PublisherService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static az.ingress.mapper.MessageMapper.MESSAGE_MAPPER;
import static az.ingress.model.constant.QueueConstant.PUBLISHER_EXCHANGE;
import static az.ingress.model.constant.QueueConstant.PUBLISHER_ROUTING_KEY;
import static lombok.AccessLevel.PRIVATE;

@Log
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class PublisherServiceHandler implements PublisherService {
    PublisherRepository publisherRepository;
    MessagePublisher messagePublisher;

    public void save(PublisherRequest request) {
        var entity = MESSAGE_MAPPER.mapRequestToEntity(request);
        var saved = publisherRepository.save(entity);
        messagePublisher.publish(PUBLISHER_EXCHANGE, PUBLISHER_ROUTING_KEY, Subscriber.from(request));
    }
}