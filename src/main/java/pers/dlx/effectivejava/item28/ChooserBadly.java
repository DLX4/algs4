package pers.dlx.effectivejava.item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// Chooser - a class badly in need of generics!
public class ChooserBadly {
    private final Object[] choiceArray;

    public ChooserBadly(Collection choices) {
        choiceArray = choices.toArray();
    }

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
