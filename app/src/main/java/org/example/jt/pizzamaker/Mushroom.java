package org.example.jt.pizzamaker;

/**
 * Created by jt on 1/13/15.
 */
public enum Mushroom {
    BUTTER, SHIITAKE, BUTTON;

    @Override
    public String toString() {
        return name().toLowerCase().replaceAll("_", " ");
    }


}
