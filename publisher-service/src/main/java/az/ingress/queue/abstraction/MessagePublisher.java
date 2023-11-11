package az.ingress.queue.abstraction;

public interface MessagePublisher {
    void publish(String exchange, String key, Object object);
}