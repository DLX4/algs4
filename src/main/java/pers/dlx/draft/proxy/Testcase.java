package pers.dlx.draft.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

public class Testcase extends ArrayList {
    public static void main(String[] args) {
        People people = new Teacher();
        InvocationHandler handler = new WorkHandler(people);
        People proxy = (People) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                people.getClass().getInterfaces(), handler);
        System.out.println(proxy.work());

    }
}
