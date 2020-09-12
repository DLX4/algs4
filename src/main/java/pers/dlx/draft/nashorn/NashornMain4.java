package pers.dlx.draft.nashorn;

import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

import javax.script.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: algs4
 * @description: nashorn 学习
 * @author: dlx
 * @created: 2020/08/12 23:09
 */
public class NashornMain4  {


    public static void main(String[] args) throws ScriptException {
        long startTime = System.currentTimeMillis();

        NashornScriptEngineFactory factory = new NashornScriptEngineFactory();
        String[] params = new String[]{"--global-per-engine"};
        ScriptEngine scriptEngine = factory.getScriptEngine(params);

        // 编写js代码
        //使用function
        String script = "var t = 4;function eval(a, b) " +
                "{" +
                "t = 4;" +
                "var res = a + b + t;" +
                "t = 1;" +
                "return res;" +
                "} " +
                "eval(x, y);";
        //预编译
        final CompiledScript compiled = ((Compilable) scriptEngine).compile(script);

        ExecutorService pool = Executors.newFixedThreadPool(10);
        AtomicInteger integer = new AtomicInteger();
        for (int i = 0; i < 1024; i++) {
            final int v = i;
            pool.submit(() -> {
                Bindings bindings = new SimpleBindings();
                bindings.put("x", v);
                bindings.put("y", 2 * v);
                try {
                    Double d = (Double) compiled.eval(bindings);
                    if (d == (3 * v + 4)) {
                        integer.incrementAndGet();
                    }
                } catch (ScriptException e) {
                    e.printStackTrace();
                }
            });
        }
        pool.shutdown();
        try {
            pool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("total true : " + integer);

        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime));
    }

}