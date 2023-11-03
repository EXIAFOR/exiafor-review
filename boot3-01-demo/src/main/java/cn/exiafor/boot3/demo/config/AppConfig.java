package cn.exiafor.boot3.demo.config;

import cn.exiafor.boot3.demo.bean.Person;
import cn.exiafor.boot3.demo.bean.Sheep;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

@Repository
@Configuration
@EnableConfigurationProperties(Sheep.class)
public class AppConfig {
    @Bean
    public Person aPerson(){
        return new Person();
    }
}
