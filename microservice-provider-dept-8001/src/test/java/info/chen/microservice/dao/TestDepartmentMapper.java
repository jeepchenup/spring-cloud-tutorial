package info.chen.microservice.dao;

import info.chen.microservice.entities.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDepartmentMapper {

    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void testLoad() {
        assertNotNull(departmentDao);
    }

    @Test
    public void testSelect() {
        System.out.println(departmentDao.findById(2L));
    }

    @Test
    public void testSelectAll() {
        List<Department> departments = departmentDao.findAll();
        departments.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        Department department = new Department();
        department.setName("IT").setDb_source("ddd");

        departmentDao.addDept(department);
    }
}
