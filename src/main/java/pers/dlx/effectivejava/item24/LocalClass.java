package pers.dlx.effectivejava.item24;

public class LocalClass {

    public static void main(String[] args) {
        Test();//局部内部类是随着方法的调用而被执行
    }
    public static void Test()
    {
        int a  =4;
        // 局部内部类
        // inner 局部内部类 不能添加访问权限修饰符
        class Inner
        {
            private int age;
            private String name;
            public void eat()
            {
                System.out.print("吃");
            }
        }
        // 局部内部类只能在声明这个内部类的方法中创建对象
        Inner inner = new Inner();
        inner.eat();
        System.out.println(inner.name);
    }
}
