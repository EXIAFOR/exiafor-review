package cn.exiafor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Emp {
    private Integer empId;
    private String empName;
    private int age;
    private char gender;
    private String email;
}
