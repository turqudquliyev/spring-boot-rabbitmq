package az.ingress.queue.concrete;

import az.ingress.aop.annotation.Log;
import az.ingress.model.queue.Subscriber;
import az.ingress.queue.abstraction.MessageSubscriber;
import az.ingress.service.abstraction.SubscriberService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static az.ingress.mapper.ObjectMapperFactory.OBJECT_MAPPER;
import static lombok.AccessLevel.PRIVATE;

@Log
@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class MessageSubscriberHandler implements MessageSubscriber {
    SubscriberService subscriberService;

    @SneakyThrows
    @RabbitListener(queues = "${rabbitmq.publisher-service.queue}")
    public void subscribe(String message) {
        var subscriber = OBJECT_MAPPER.getInstance().readValue(message, Subscriber.class);
        subscriberService.save(subscriber);
    }
}