package org.example.jt.pizzamaker;

/**
 * Created by jt on 1/13/15.
 */
public enum Pineapple {
    SARAWAK, PENINSULA, IMPORTED;

    @Override
    public String toString() {
        return name().toLowerCase();
    }


}
