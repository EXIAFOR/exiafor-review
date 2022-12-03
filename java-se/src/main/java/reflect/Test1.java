package reflect;

import bean.Person;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public class Test1 {
    @Test
    public void test1() {
        for (int i = 0; i < 100; ++i) {
            int num = new Random().nextInt(3);//0,1,2
            String classPath = "";

            switch (num) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = Person.class.getCanonicalName();
                    break;
            }

            Object obj = null;
            try {
                obj = getInstance(classPath);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            System.out.println(obj);

        }
    }

    @Test
    public void test2() throws IOException {
        Properties pros = new Properties();

        ClassLoader classLoader = this.getClass().getClassLoader();

        InputStream is = classLoader.getResourceAsStream("config\\test.properties");

        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        System.out.println("user = " + user + "\npassword = " + password);
    }

    public Object getInstance(String classPath) throws Exception {
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
