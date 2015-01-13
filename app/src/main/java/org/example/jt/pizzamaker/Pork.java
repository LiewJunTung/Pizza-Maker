package org.example.jt.pizzamaker;

/**
 * Created by jt on 1/13/15.
 */
public enum Pork {
    BACON, BBQ;

    @Override
    public String toString() {
        return name().toLowerCase();
    }


}
