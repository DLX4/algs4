package pers.dlx.effectivejava.item24;

import java.util.ArrayList;

public class Outer {

    private String name;

    public Outer(String name) {
        this.name = name;
    }

    private void fuck() {
        System.out.println("fuck" + name);
    }

    private void fuck2() {

    }

    class Inner {

        public Inner() {}

        private void fuck22() {
            Outer.this.name = "3333";
            Outer.this.fuck();
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer("111");
        Outer.Inner inner = outer.new Inner();
        inner.fuck22();

        Comparable c = new Comparable() {
            public final static String AA = "1213";
            // 果然不可以they cannot have any static members other than constant variables, which are final primitive or string fields initialized to constant expressions [JLS, 4.12.4].
            // public final static ArrayList aaa = new ArrayList();
            @Override
            public int compareTo(Object o) {
                // 匿名类只有在非静态环境中定义的情况下才具有外部类实例
                System.out.println(outer.name);
                return 0;
            }
        };
        // 不能调用c.AA
    }
}
