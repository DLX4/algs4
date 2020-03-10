package pers.dlx.effectivejava.item10;

public class EqualsTest1 {

    public static void main(String[] args) {

        class Status {
            public String status;
        }

        Status s1 = new Status();
        Status s2 = new Status();

        System.out.println(s1==s2); // false
        System.out.println(s1.equals(s2)); // false
    }
}
