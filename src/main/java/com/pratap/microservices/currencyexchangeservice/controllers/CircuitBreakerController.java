package com.pratap.microservices.currencyexchangeservice.controllers;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class CircuitBreakerController {

    @GetMapping("/sample-api")
//    @Retry(name = "sample-api", fallbackMethod = "getHardcodedResponse")
    @CircuitBreaker(name = "sample-api", fallbackMethod = "getHardcodedResponse")
    public String getSampleApi(){
        log.info("Executing getSampleApi()");
        return new RestTemplate().getForEntity("http://localhost:8080/dummy-service", String.class).getBody();
    }

    private String getHardcodedResponse(Exception exception){
        log.info("Executing getHardcodedResponse()");
        return "fallback-response";
    }
}
