package pers.dlx.effectivejava.item13;

import pers.dlx.effectivejava.item10.PhoneNumber;

public class CloneTest implements Cloneable {
    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber(1, 1, 1);
        // 这里不能调用clone方法
    }
}
