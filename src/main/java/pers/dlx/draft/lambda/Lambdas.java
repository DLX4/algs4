package pers.dlx.draft.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparingInt;

/**
 * @program: algs4
 * @description: lambdas用法
 * @author: dlx
 * @created: 2020/08/29 22:59
 */
public class Lambdas {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "apple", "pear");

        // Lambda expression as function object (replaces anonymous class)
        Collections.sort(words,(s1, s2) -> Integer.compare(s1.length(), s2.length()));

        Collections.sort(words, comparingInt(String::length));

        words.sort(comparingInt(String::length));

        System.out.println(words);
    }
}