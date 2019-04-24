package info.chen.microservice.provider.controller;

import info.chen.microservice.entities.Department;
import info.chen.microservice.provider.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Department department) {
        System.out.println("provider : " + department);
        return service.add(department);
    }

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping("/dept/all")
    public List<Department> getAll() {
        return service.list();
    }

    @GetMapping("/dept/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        System.out.println("Current register services in Eureka : " + services);

        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("microservice-department-provider");
        serviceInstances.forEach(instance -> {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        });
        return discoveryClient;
    }
}
