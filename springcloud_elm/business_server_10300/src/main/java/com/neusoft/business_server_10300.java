package com.neusoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication

public class business_server_10300 {
    //向容器中添加RestTemplate实例
//    @Bean
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }
    public static void main(String[] args) {
        SpringApplication.run(business_server_10300.class, args);
    }
}