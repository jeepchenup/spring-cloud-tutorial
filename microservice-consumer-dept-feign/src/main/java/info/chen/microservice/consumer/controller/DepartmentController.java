package info.chen.microservice.consumer.controller;

import info.chen.microservice.entities.Department;
import info.chen.microservice.service.DeptServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DeptServiceClient deptServiceClient;

    @PostMapping("/dept/add")
    public boolean add(Department dept) {
        return deptServiceClient.add(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Department get(@PathVariable("id") Long id) {
        return deptServiceClient.get(id);
    }

    @GetMapping("/dept/all")
    public List<Department> list() {
        return deptServiceClient.list();
    }

}
