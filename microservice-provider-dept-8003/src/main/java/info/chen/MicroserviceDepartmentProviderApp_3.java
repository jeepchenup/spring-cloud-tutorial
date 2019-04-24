package info.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
public class MicroserviceDepartmentProviderApp_3 {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDepartmentProviderApp_3.class, args);
    }
}
