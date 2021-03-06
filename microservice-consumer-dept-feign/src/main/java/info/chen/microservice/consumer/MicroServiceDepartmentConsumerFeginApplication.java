package info.chen.microservice.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author Edison Chen
 * @date   2019-06-07
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"info.chen.microservice"})
public class MicroServiceDepartmentConsumerFeginApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceDepartmentConsumerFeginApplication.class, args);
    }
}
