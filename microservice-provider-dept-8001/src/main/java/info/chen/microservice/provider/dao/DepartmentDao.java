package info.chen.microservice.provider.dao;

import info.chen.microservice.entities.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface DepartmentDao {

    @Insert("INSERT INTO dept(dname, db_source) VALUES(#{name}, DATABASE())")
    @Results({
            @Result(property = "id", column = "deptno"),
            @Result(property = "name", column = "dname")
    })
    public boolean addDept(Department dept);

    @Select("SELECT * FROM dept WHERE deptno=#{id}")
    @Results({
            @Result(property = "id", column = "deptno"),
            @Result(property = "name", column = "dname")
    })
    public Department findById(Long id);

    @Select("SELECT * FROM dept")
    @Results({
            @Result(property = "id", column = "deptno"),
            @Result(property = "name", column = "dname")
    })
    public List<Department> findAll();

}
