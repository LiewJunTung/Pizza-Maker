package org.example.jt.pizzamaker;

/**
 * Created by jt on 1/13/15.
 */
public enum Cheese {
    MOZZARELLA, PARMESAN, BLUE_CHEESE;

    @Override
    public String toString() {
        return name().toLowerCase().replaceAll("_", " ");
    }


}
