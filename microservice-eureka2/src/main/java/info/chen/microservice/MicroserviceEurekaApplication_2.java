package info.chen.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceEurekaApplication_2 {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceEurekaApplication_2.class, args);
    }
}
