package pers.dlx.draft.nashorn;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: algs4
 * @description: nashorn 学习
 * @author: dlx
 * @created: 2020/08/12 23:09
 */
public class NashornMain2 {

    public static String say(String str) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        return list + "hello, " + str;
    }

    public final static String SCRIPT = "" +
            "var MyJavaClass = Java.type('pers.dlx.draft.nashorn.NashornMain2');\n" +
            "var result = MyJavaClass.say('Nashorn');\n" +
            "print(result);";

    public final static String SCRIPT2 = "var ArrayList = Java.type('java.util.ArrayList');\n" +
            "var list = new ArrayList();\n" +
            "list.add('a');\n" +
            "list.add('b');\n" +
            "list.add('c');\n" +
            "\n" +
            "for each (var el in list) {\n" +
            "    print(el);  // a, b, c\n" +
            "}";

    public static void main(String[] args) throws ScriptException {
        final int N = 100;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
            Bindings bindings = engine.createBindings();
            bindings.put("name", "Nashorn");

            engine.eval("print('Hello ' + name);", bindings);
            engine.eval(SCRIPT);
            engine.eval(SCRIPT2);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime));

    }

}