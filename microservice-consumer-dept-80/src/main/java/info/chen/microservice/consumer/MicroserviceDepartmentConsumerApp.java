package info.chen.microservice.consumer;

import info.chen.microservice.rule.RibbonRuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(value = "MICROSERVICE-DEPARTMENT-PROVIDER", configuration = RibbonRuleConfiguration.class)
public class MicroserviceDepartmentConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDepartmentConsumerApp.class, args);
    }
}
