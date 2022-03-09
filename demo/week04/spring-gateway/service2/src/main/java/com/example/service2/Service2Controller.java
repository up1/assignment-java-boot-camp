package com.example.service2;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/service2")
public class Service2Controller {

    @GetMapping(value = "/hi")
    public Mono<String> sayHi(ServerHttpRequest request,
                              ServerHttpResponse response) {
        HttpHeaders headers = request.getHeaders();
        printHeaders(headers);

        Mono<String> result = Mono.just("Hello from service 2");
        return result;
    }

    private void printHeaders(HttpHeaders headers) {
        headers.forEach((k, v)->{
            System.out.println(k + " : " + v);
        });
    }
}
