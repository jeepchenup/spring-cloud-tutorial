package info.chen.microservice.provider.controller;

import info.chen.microservice.entities.Department;
import info.chen.microservice.provider.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService service;

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
}
