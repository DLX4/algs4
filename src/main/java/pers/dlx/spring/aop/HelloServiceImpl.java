package pers.dlx.spring.aop;

/**
 * @program: algs4
 * @description: 实现类
 * @author: dlx
 * @created: 2020/09/04 07:35
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        if (name == null || name.trim() == "") {
            throw new RuntimeException("parameter is null!!");
        }
        System.out.println("hello " + name);
    }
}