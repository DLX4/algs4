package pers.dlx.effectivejava.item14;

import java.util.Comparator;

import static java.util.Comparator.comparingInt;

// Class with a typical equals method
public final class PhoneNumber2 implements Cloneable {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber2(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber2))
            return false;

        PhoneNumber2 pn = (PhoneNumber2)o;
        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
    }
    // Remainder omitted

    // Clone method for class with no references to mutable state
    @Override public PhoneNumber2 clone() {
        try {
            return (PhoneNumber2) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }

    // Comparable with comparator construction methods
    private static final Comparator<PhoneNumber2> COMPARATOR = comparingInt(
            (PhoneNumber2 pn) -> pn.areaCode)
            .thenComparingInt(pn -> pn.prefix)
            .thenComparingInt(pn -> pn.lineNum);

    public int compareTo(PhoneNumber2 pn) {
        return COMPARATOR.compare(this, pn);
    }
}
