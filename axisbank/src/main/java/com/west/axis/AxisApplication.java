package com.west.axis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class AxisApplication {

    @GetMapping("/")
    public String home() {
        return "Hello, Testing from Axis Bank!  succesfull deployment in ecs";
    }

    // @GetMapping("/health")
    // public String health() {
    //     return "OK";
    // }

    @GetMapping("/health")
    public String health(@RequestParam(required = false) String fail) {

        if ("true".equals(fail)) {
            throw new RuntimeException("Simulated failure");
        }

        return "OK";
    }

    @PostConstruct
    public void init() {

        String failStartup = System.getenv("FAIL_STARTUP");

        if ("true".equals(failStartup)) {
            throw new RuntimeException("Simulated startup failure for rollback test");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(AxisApplication.class, args);
    }
}