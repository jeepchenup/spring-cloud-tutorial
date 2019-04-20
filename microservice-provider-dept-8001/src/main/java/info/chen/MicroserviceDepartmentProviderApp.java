package info.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceDepartmentProviderApp {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDepartmentProviderApp.class, args);
    }
}
