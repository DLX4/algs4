package pers.dlx.spring.aop;


/**
 * @program: algs4
 * @description:
 * @author: dlx
 * @created: 2020/09/04 08:17
 */
public class MyInterceptor implements Interceptor {
    @Override
    public boolean before() {
        System.out.println("before ......");
        return true;
    }

    @Override
    public void after() {
        System.out.println("after ......");
    }

    @Override
    public Object around(Invocation invocation) throws Throwable {
        System.out.println("around before ......");
        Object obj = invocation.proceed();
        System.out.println("around after ......");
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("after returning......");
    }

    @Override
    public void afterThrowing() {
        System.out.println("after throwing.......");
    }

    @Override
    public boolean useAround() {
        return false;
    }
}