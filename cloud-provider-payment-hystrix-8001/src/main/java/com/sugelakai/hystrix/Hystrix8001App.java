package com.sugelakai.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @author kai
 * @date 2020/9/11 16:04
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class Hystrix8001App {

    public static void main(String[] args) {
        new SpringApplication(Hystrix8001App.class).run(args);
    }

}
