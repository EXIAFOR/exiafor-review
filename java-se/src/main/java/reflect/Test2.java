package reflect;

import bean.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test2 {
    public void test1() {
        Class<Person> clazz = Person.class;

        Field[] fields = clazz.getFields();

        for (Field field : fields) {
            System.out.println(field);
        }

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        System.out.println();

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println();

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

    public void test2() {
        Class<Person> clazz = Person.class;

        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println();

        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }

    public void test3() {
        Class<Person> clazz = Person.class;

        Class<? super Person> superclass = clazz.getSuperclass();

        System.out.println(superclass);
    }

    public void test4() {
        Class<Person> personClass = Person.class;

        System.out.println(personClass.getCanonicalName());

    }

    public void test5() throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Person> personClass = Person.class;

        Person person = personClass.newInstance();

        Field name = personClass.getDeclaredField("name");

        name.setAccessible(true);
        name.set(person, "Tom");

        System.out.println(name.get(person));
    }

    public void test6() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class<Person> pClass = Person.class;

        Method method = pClass.getDeclaredMethod("eat");

        method.invoke(new Person());
    }

    public void test7() throws Exception {
        Class<Person> personClass = Person.class;

        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(Integer.class);

        Person person = declaredConstructor.newInstance(18);

        System.out.println(person);
    }
}
