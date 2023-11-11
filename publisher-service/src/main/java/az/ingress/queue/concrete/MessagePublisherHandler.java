package az.ingress.queue.concrete;

import az.ingress.aop.annotation.Log;
import az.ingress.queue.abstraction.MessagePublisher;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static az.ingress.mapper.ObjectMapperFactory.OBJECT_MAPPER;
import static lombok.AccessLevel.PRIVATE;

@Log
@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class MessagePublisherHandler implements MessagePublisher {
    RabbitTemplate rabbitTemplate;

    @SneakyThrows
    public void publish(String exchange, String key, Object object) {
        var message = OBJECT_MAPPER.getInstance().writeValueAsString(object);
        rabbitTemplate.convertAndSend(exchange, key, message);
    }
}