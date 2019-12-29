package pers.dlx.algs4;

import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac Sort2distinct.java
 *  Execution:    java  Sort2distinct binary-string
 *  Dependencies: StdOut.java
 *
 *  Partitions the array of specified as the command-line.
 *  Assumes there are at most 2 distinct elements.
 *
 ******************************************************************************/

public class Sort2distinct {

    // rearranges a[] in ascending order assuming a[] has at most 3 distinct values
    public static void sort(Comparable[] a) {
        int lt = 0, gt = a.length - 1;
        int i = 0;//或者 lt + 1

        while (i <= gt) { // 每次循环i和gt之间的距离都会被缩小；i和gt之间的数是还没有比较的
            Comparable v = a[lt];
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(a, lt, i);
                i++;
                lt++;
            } else if (cmp > 0) {
                exch(a, i, gt);
                gt--;
            } else {
                i++;
            }
        }
    }

    // exchange a[i] and a[j]
    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // test client
    public static void main(String[] args) {

        // parse command-line argument as an array of 1-character strings
        String s = args[0];
        int n = s.length();
        String[] a = new String[n];
        for (int i = 0; i < n; i++)
            a[i] = s.substring(i, i+1);

        // sort a print results
        sort(a);
        for (int i = 0; i < n; i++)
            StdOut.print(a[i]);
        StdOut.println();
    }

}
