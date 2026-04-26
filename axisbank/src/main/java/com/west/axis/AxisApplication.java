package com.west.axis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class AxisApplication {

    @GetMapping("/")
    public String home() {
        return "Hello, Testing from Axis Bank! tbis is the new appplication from the Ec2 if failed then rollback";
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

    public static void main(String[] args) {
        SpringApplication.run(AxisApplication.class, args);
    }
}