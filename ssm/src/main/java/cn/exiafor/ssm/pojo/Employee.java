package cn.exiafor.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    private Integer empId;
    private String empName;
    private Integer age;
    // 1为男性male
    // 0为女性female
    private Character gender;
    private String email;
}
