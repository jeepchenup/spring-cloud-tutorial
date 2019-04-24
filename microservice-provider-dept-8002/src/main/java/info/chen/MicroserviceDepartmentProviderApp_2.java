package info.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
public class MicroserviceDepartmentProviderApp_2 {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDepartmentProviderApp_2.class, args);
    }
}
