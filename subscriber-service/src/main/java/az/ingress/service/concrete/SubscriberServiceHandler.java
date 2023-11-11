package az.ingress.service.concrete;

import az.ingress.aop.annotation.Log;
import az.ingress.dao.repository.SubscriberRepository;
import az.ingress.model.queue.Subscriber;
import az.ingress.service.abstraction.SubscriberService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static az.ingress.mapper.SubscriberMapper.SUBSCRIBER_MAPPER;
import static lombok.AccessLevel.PRIVATE;

@Log
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class SubscriberServiceHandler implements SubscriberService {
    SubscriberRepository subscriberRepository;

    public void save(Subscriber subscriber) {
        var entity = SUBSCRIBER_MAPPER.mapRequestToEntity(subscriber);
        subscriberRepository.save(entity);
    }
}