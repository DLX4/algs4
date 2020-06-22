package pers.dlx.draft.string;

public class StringLength {

    public static void main(String[] args) {
//        String s = "helloworld中国";
//        System.out.println(s.charAt(10));

        // 中文常见字
        String s = "你好";
        System.out.println("1. string length =" + s.length());
        System.out.println("1. string bytes length =" + s.getBytes().length);
        System.out.println("1. string char length =" + s.toCharArray().length);
        System.out.println(s.charAt(0));
        System.out.println(s.codePointAt(0));
        System.out.println(s.codePointAt(1));
        System.out.println(s.codePointCount(0, s.length()));
        System.out.println();
        // emojis
        s = "👦👩";
        System.out.println("2. string length =" + s.length());
        System.out.println("2. string bytes length =" + s.getBytes().length);
        System.out.println("2. string char length =" + s.toCharArray().length);
        System.out.println(s.charAt(0));
        System.out.println(s.codePointAt(0));
        System.out.println(s.codePointAt(1));
        System.out.println(s.codePointAt(2));
        System.out.println(s.codePointAt(3));
        System.out.println(s.codePointCount(0, s.length()));
        System.out.println();
        // 中文生僻字
        s = "𡃁妹";
        System.out.println("3. string length =" + s.length());
        System.out.println("3. string bytes length =" + s.getBytes().length);
        System.out.println("3. string char length =" + s.toCharArray().length);
        System.out.println(s.charAt(0));
        System.out.println(s.codePointAt(0));
        System.out.println(s.codePointAt(1));
        System.out.println(s.codePointCount(0, s.length()));
        System.out.println();
    }
}
