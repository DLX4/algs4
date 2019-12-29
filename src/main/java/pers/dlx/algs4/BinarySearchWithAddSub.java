/******************************************************************************
 *  Compilation:  javac BinarySearch.java
 *  Execution:    java BinarySearch whitelist.txt < input.txt
 *  Dependencies: In.java StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/11model/tinyW.txt
 *                https://algs4.cs.princeton.edu/11model/tinyT.txt
 *                https://algs4.cs.princeton.edu/11model/largeW.txt
 *                https://algs4.cs.princeton.edu/11model/largeT.txt
 *
 *  % java BinarySearch tinyW.txt < tinyT.txt
 *  50
 *  99
 *  13
 *
 *  % java BinarySearch largeW.txt < largeT.txt | more
 *  499569
 *  984875
 *  295754
 *  207807
 *  140925
 *  161828
 *  [367,966 total values]
 *  
 ******************************************************************************/

package pers.dlx.algs4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;


public class BinarySearchWithAddSub {

    /**
     * This class should not be instantiated.
     */
    private BinarySearchWithAddSub() { }

    // [start, k]搜索范围 n1=Fibonacci(k), n2=Fibonacci(k-1)
    public static int indexOf(int[] a, int start, int n1, int n2, int key) {
        if (start >= a.length - 1 || n2 < 1) {return -1;}

        // n3=Fibonacci(k-2)
        int n3 = n1 - n2;
        int checkVal;
        if (start + n3 > a.length - 1) {
            checkVal = Integer.MAX_VALUE;
        } else {
            checkVal = a[start + n3];
            if (n3 == 0 && checkVal != key) return -1;
        }

        if (checkVal > key) {
            return indexOf(a, start, n3, n2 - n3, key);
        } else if (checkVal < key) {
            return indexOf(a, start + n3, n2, n3, key);
        } else return start + n3;

    }

    /**
     * Reads in a sequence of integers from the whitelist file, specified as
     * a command-line argument; reads in integers from standard input;
     * prints to standard output those integers that do <em>not</em> appear in the file.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        // read the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);

        int n1 = 1;
        int n2 = 1;
        int fib = 1;
        while((n1 + n2) < whitelist.length - 1) {
            fib = n1 + n2;
            n2 = n1;
            n1 = fib;
        }

        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();

            int res = BinarySearchWithAddSub.indexOf(whitelist, 0, n1 + n2, n1, key);
            StdOut.println(res);
        }
    }
}
