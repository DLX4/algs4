package pers.dlx.spring.aop;


import java.lang.reflect.InvocationTargetException;

/**
 * @program: algs4
 * @description:
 * @author: dlx
 * @created: 2020/09/04 08:13
 */
public interface Interceptor {

    boolean before();

    // 事后方法
    void after();

    /**
     * 取代原有事件方法
     *
     * @param invocation -- 回调参数，可以通过它的proceed方法，回调原有事件
     * @return 原有事件返回对象
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    Object around(Invocation invocation)
            throws Throwable;

    // 是否返回方法。事件没有发生异常执行
    void afterReturning();

    // 事后异常方法，当事件发生异常后执行
    void afterThrowing();

    // 是否使用around方法取代原有方法
    boolean useAround();
}