package pers.dlx.draft.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: algs4
 * @description: 匿名内部类
 * @author: dlx
 * @created: 2020/08/29 22:47
 */
public class Anonymous {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "apple", "pear");

        // Anonymous class instance as a function object - obsolete!
        Collections.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        System.out.println(words);
    }
}