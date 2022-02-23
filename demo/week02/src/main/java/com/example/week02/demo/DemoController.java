package com.example.week02.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private static final Logger log
            = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoGateway demoGateway;

    @GetMapping("/demo")
    public String simpleLog() {
        log.info("Called simple logging");
        return "Working with simple logging";
    }

    @GetMapping("/demo-call")
    public String simpleLog02() {
        log.info("Called simple logging 02");
        demoGateway.call();
        throw new RuntimeException("Error");
//        return "Working with simple logging 02";
    }

}
