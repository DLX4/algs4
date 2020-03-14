package pers.dlx.effectivejava.item20;

public interface TestInterface {

    default public boolean equals1(Object obj) {
        return true;
    }

    // 不能在接口里面给Object的equals方法等提供default method。（测试过确实如此）
//    default public boolean equals(Object obj) {
//        return (this == obj);
//    }

    // private final static String TEST = "123";
}
