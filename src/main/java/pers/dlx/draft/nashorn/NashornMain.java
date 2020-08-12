package pers.dlx.draft.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @program: algs4
 * @description: nashorn 学习
 * @author: dlx
 * @created: 2020/08/12 23:09
 */
public class NashornMain {
    public static void main(String[] args) throws ScriptException {
        final int N = 1000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
            engine.eval("print('Hello World!');");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时："+(endTime - startTime));

    }

}