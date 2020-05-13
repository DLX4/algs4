package pers.dlx.effectivejava.item26;

import java.util.ArrayList;
import java.util.List;

public class Generics2 {

    // Fails at runtime - unsafeAdd method uses a raw type (List)!
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        // 下面这行会报错
        // unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0); // Has compiler-generated cast
    }

    private static void unsafeAdd(List<Object> list, Object o) {
        list.add(o);
    }
}
