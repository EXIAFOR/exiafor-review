package cn.exiafor.boot3.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ConfigurationProperties("pig")
@Component
public class Pig {
    private int id;
    private String name;
    private int age;
}
