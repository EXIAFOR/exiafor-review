package cn.exiafor;

import cn.exiafor.aspect.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemoXml {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");

        Book book = context.getBean(Book.class);

        book.buy();
    }
}
