package pers.dlx.effectivejava.item15;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author dinglingxiang  2020/3/11 14:54
 */
public class Accessibility2 {

    private static final Thing[] PRIVATE_VALUES = { new Thing()};
    public static final Thing[] values() {
        return PRIVATE_VALUES.clone();
    }
}
