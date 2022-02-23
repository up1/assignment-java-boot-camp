package com.example.week02.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DemoGateway {

    private static final Logger log
            = LoggerFactory.getLogger("outbound-logs");

    public void call() {
        log.info("Call external service");
    }

}
