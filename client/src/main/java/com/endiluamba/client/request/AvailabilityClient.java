package com.endiluamba.client.request;

import com.endiluamba.client.model.Availability;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class AvailabilityClient {

    private final WebClient webClient;
    private static final String URI = "http://localhost:8083/availability/{console}";

    public Mono<Availability> checkAvailability(String console) {
        return this.webClient
                .get()
                .uri(URI, console)
                .retrieve()
                .bodyToMono(Availability.class)
                .onErrorReturn(new Availability(false, console));
    }
}
