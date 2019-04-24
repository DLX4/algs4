package algs4.draft.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Testcase {
    public static void main(String[] args) {
        People people = new Teacher();
        InvocationHandler handler = new WorkHandler(people);
        People proxy = (People) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                people.getClass().getInterfaces(), handler);
        System.out.println(proxy.work());
    }
}
