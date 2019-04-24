package info.chen.microservice.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceDepartmentConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDepartmentConsumerApp.class, args);
    }
}
