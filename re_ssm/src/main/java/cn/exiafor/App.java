package cn.exiafor;

import cn.exiafor.controller.UserController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        final ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("app.xml");

        int count = 1;
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(count + " --> " + beanDefinitionName);
            ++count;
        }

        context.getBean(UserController.class).saveUser();
    }
}
