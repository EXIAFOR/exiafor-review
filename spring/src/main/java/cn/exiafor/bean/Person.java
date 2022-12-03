package cn.exiafor.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Repository
public class Person {
    private String name;
    private Integer age;
}
