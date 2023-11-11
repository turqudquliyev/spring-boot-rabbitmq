package az.ingress.model.queue;

import az.ingress.model.request.PublisherRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = PRIVATE)
public class Subscriber {
    String parameter;

    public static Subscriber from(PublisherRequest request) {
        return Subscriber.builder()
                .parameter(request.getSubscriberParameter())
                .build();
    }
}