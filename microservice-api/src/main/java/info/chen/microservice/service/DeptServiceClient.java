package info.chen.microservice.service;

import info.chen.microservice.entities.Department;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "MICROSERVICE-DEPARTMENT-PROVIDER")
public interface DeptServiceClient {

    @PostMapping("/dept/add")
    public boolean add(Department dept);

    @GetMapping("/dept/get/{id}")
    public Department get(@PathVariable("id") Long id);

    @GetMapping("/dept/all")
    public List<Department> list();
}
