package pers.dlx.spring.aop;

/**
 * @program: algs4
 * @description:
 * @author: dlx
 * @created: 2020/09/04 08:20
 */
public class Test {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new
                MyInterceptor());

        proxy.sayHello("zhangsan");
        System.out.println("\n###############name is null!!#############\n");
        proxy.sayHello(null);
    }
}