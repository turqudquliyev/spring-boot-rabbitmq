package az.ingress.controller;

import az.ingress.aop.annotation.Log;
import az.ingress.model.request.PublisherRequest;
import az.ingress.service.abstraction.PublisherService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.CREATED;

@Log
@RestController
@RequestMapping("/v1/messages")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class PublisherController {
    PublisherService publisherService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void create(@RequestBody PublisherRequest request) {
        publisherService.save(request);
    }
}