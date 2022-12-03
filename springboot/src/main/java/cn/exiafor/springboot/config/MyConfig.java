package cn.exiafor.springboot.config;

import cn.exiafor.springboot.bean.Pet;
import cn.exiafor.springboot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public User user01() {
        User zhangsan = new User("zhangsan", 18, null);
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

    @Bean("tom")
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }
}
