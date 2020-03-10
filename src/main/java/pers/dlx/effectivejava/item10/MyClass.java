package pers.dlx.effectivejava.item10;

public class MyClass {

    // Broken - parameter type must be Object!
    public boolean equals(MyClass o) {
        // ...
        return true;
    }
}
