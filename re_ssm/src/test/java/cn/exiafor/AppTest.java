package cn.exiafor;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class AppTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app.xml");

        Hello hello = context.getBean(Hello.class);

        hello.say();

        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
    }
}
