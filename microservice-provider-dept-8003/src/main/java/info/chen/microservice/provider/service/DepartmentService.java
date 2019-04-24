package info.chen.microservice.provider.service;


import info.chen.microservice.entities.Department;

import java.util.List;

public interface DepartmentService {
    public boolean add(Department dept);
    public Department    get(Long id);
    public List<Department> list();
}
