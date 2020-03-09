package pers.dlx.effectivejava.item2;

import static pers.dlx.effectivejava.item2.NyPizza.Size.SMALL;
import static pers.dlx.effectivejava.item2.Pizza.Topping.HAM;
import static pers.dlx.effectivejava.item2.Pizza.Topping.ONION;
import static pers.dlx.effectivejava.item2.Pizza.Topping.SAUSAGE;

public class Client {

    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();
    }
}
