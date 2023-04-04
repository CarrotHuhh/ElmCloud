package com.neusoft;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@SpringBootApplication
@EnableEurekaServer  //激活Eureka Server
public class eureka_server_13000 {
    public static void main(String[] args) {
        SpringApplication.run(eureka_server_13000.class, args);
    }
}