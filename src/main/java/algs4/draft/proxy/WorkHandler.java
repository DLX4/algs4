package algs4.draft.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class WorkHandler implements InvocationHandler {

    private Object obj;

    public WorkHandler() {

    }
    public WorkHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke do sth");
        Object invoke = method.invoke(obj, args);
        System.out.println("after invoke do sth");
        return invoke;
    }
}
