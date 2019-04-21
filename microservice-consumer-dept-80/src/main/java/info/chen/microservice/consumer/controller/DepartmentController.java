package info.chen.microservice.consumer.controller;

import info.chen.microservice.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DepartmentController {

    private static final String dept_host = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Long id) {
        return restTemplate.getForObject(dept_host + "/dept/" + id, Department.class);
    }

    @GetMapping("/dept/all")
    public List<Department> getAll() {
        return restTemplate.getForObject(dept_host + "/dept/all", List.class);
    }

    @PostMapping("/dept/add")
    public boolean addDept(Department department) {
        System.out.println("consumer: " + department);
        return restTemplate.postForObject(dept_host + "/dept/add", department, Boolean.class);
    }

    @GetMapping("/dept/discovery")
    public Object discoveryService() {
        return restTemplate.getForObject(dept_host + "/dept/discovery", Object.class);
    }
}
