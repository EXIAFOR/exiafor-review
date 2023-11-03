package cn.exiafor.boot3.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ConfigurationProperties("sheep")
public class Sheep {
    private int id;
    private String name;
    private int age;
}
