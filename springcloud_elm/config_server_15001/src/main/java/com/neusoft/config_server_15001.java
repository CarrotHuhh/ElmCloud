package com.neusoft;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
@SpringBootApplication
@EnableConfigServer     //开启springcloud config服务端注解
public class config_server_15001 {
    public static void main(String[] args) {
        SpringApplication.run(config_server_15001.class, args);
    }
}