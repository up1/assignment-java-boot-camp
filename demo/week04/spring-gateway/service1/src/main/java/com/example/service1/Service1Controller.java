package com.example.service1;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/service1")
public class Service1Controller {

    @GetMapping(value = "/hi")
    public Mono<String> sayHi(ServerHttpRequest request,
                              ServerHttpResponse response) {
        HttpHeaders headers = request.getHeaders();

        printHeaders(headers);

        ResponseCookie.ResponseCookieBuilder builder = ResponseCookie.from(
                "service1-token", "service-token-value");
        ResponseCookie cookie = builder.build();
        response.addCookie(cookie);

        Mono<String> result = Mono.just("Hello from service 1");
        return result;
    }

    private void printHeaders(HttpHeaders headers) {
        headers.forEach((k, v)->{
            System.out.println(k + " : " + v);
        });
    }
}
