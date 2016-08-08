package org.example.jt.pizzamaker;

/**
 * Created by jt on 1/13/15.
 */
public class Pizza {
    private final String LOG_TAG = "PIZZA";
    private final String name;
    private final Cheese cheese;
    private final Pork pork;
    private final Pineapple pineapple;
    private final Mushroom mushroom;
    private final Chicken chicken;
    private final Chilli chilli;

    public String getName() {
        return name;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public Pork getPork() {
        return pork;
    }

    public Pineapple getPineapple() {
        return pineapple;
    }

    public Mushroom getMushroom() {
        return mushroom;
    }

    public Chicken getChicken() {
        return chicken;
    }

    public Chilli getChilli() {
        return chilli;
    }

    public Pizza(PizzaMaker pizzaMaker) {
        this.name = pizzaMaker.name;
        this.cheese = pizzaMaker.cheese;
        this.chicken = pizzaMaker.chicken;
        this.pork = pizzaMaker.pork;
        this.pineapple = pizzaMaker.pineapple;
        this.mushroom = pizzaMaker.mushroom;
        this.chilli = pizzaMaker.chilli;

    }

    @Override
    public String toString() {
        return "Cheese=" + cheese + '\n' +
               "Pork=" + pork + '\n' +
               "Pineapple=" + pineapple + '\n' +
               "Mushroom=" + mushroom + '\n' +
               "Chicken=" + chicken + '\n' +
               "Chilli=" + chilli ;
    }

    public static class PizzaMaker{
        private final String name;
        private Cheese cheese;
        private Pork pork;
        private Pineapple pineapple;
        private Mushroom mushroom;
        private Chilli chilli;
        private Chicken chicken;

        public PizzaMaker(String name) {
            this.name = setName(name);
        }

        private String setName(String name){

            if(name == null || name.trim().isEmpty()){
                return "Pizza with No Name";
            }
            else{
                return name;
            }
        }

        public PizzaMaker addChicken(Chicken chicken){
            this.chicken = chicken;
            return this;
        }


        public PizzaMaker addCheese(Cheese cheese){
            this.cheese = cheese;
            return this;
        }

        public PizzaMaker addPork(Pork pork){
            this.pork = pork;
            return this;
        }

        public PizzaMaker addPineapple(Pineapple pineapple){
            this.pineapple = pineapple;
            return this;
        }

        public PizzaMaker addMushroom(Mushroom mushroom){
            this.mushroom = mushroom;
            return this;
        }

        public PizzaMaker addChilli(Chilli chilli){
            this.chilli = chilli;
            return this;
        }

        public Pizza build(){
            return new Pizza(this);
        }


    }
}
