package pers.dlx.draft.arrayList;

import java.util.Arrays;

public class ArrayCopy {

    // 下面的效果是插入一个元素
    public static void main1(String[] args) {
        int[] a = new int[10];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        System.arraycopy(a, 2, a, 3, 3);
        a[2]=99;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    // 扩容复制原来的
    public static void main(String[] args) {
        int[] a = new int[3];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        int[] b = Arrays.copyOf(a, 10);
        System.out.println("b.length"+b.length);
    }
}
