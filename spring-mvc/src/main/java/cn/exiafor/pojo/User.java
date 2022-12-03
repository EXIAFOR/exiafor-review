package cn.exiafor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {
    private String username;
    private String password;
    private String sex;
    private Integer age;
    private String email;
}
