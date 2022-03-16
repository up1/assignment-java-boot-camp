package com.example.week02.login;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private MeterRegistry meterRegistry;

    @GetMapping("/login/{status}")
    public String login(@PathVariable  String status) {
        meterRegistry.counter("login_count", "status", status).increment();
        return "TODO with " + status;
    }

}
