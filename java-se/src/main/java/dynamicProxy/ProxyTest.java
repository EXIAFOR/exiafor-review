package dynamicProxy;

import java.util.Objects;

public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();

        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);

        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川麻辣烫");

        System.out.println("**********************************");


    }
}
