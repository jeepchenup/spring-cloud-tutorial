package info.chen.microservice.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@NoArgsConstructor
@Data
public class Department implements Serializable {

    // 部门编号
    private Long id;
    // 部门名称
    private String name;
    // 数据库名称
    private String db_source;

    public Department(String name) {
        this.name = name;
    }

}
