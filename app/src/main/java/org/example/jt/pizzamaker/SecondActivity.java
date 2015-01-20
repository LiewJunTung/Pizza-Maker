package org.example.jt.pizzamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by jt on 1/13/15.
 */
public class SecondActivity extends ActionBarActivity {
    private ListView mPizzaDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        mPizzaDescription = (ListView) findViewById(R.id.pizza_description);

        String pizza_name = intent.getStringExtra(MainActivity.PIZZA_NAME);
        Cheese pizza_cheese = Cheese.valueOf(intent.getStringExtra(MainActivity.PIZZA_CHEESE));
        Chicken pizza_chicken = Chicken.valueOf(intent.getStringExtra(MainActivity.PIZZA_CHICKEN));
        Chilli pizza_chilli = Chilli.valueOf(intent.getStringExtra(MainActivity.PIZZA_CHILLI));
        Mushroom pizza_mushroom = Mushroom.valueOf(intent.getStringExtra(MainActivity.PIZZA_MUSHROOM));
        Pork pizza_pork = Pork.valueOf(intent.getStringExtra(MainActivity.PIZZA_PORK));
        Pineapple pizza_pineapple = Pineapple.valueOf(intent.getStringExtra(MainActivity.PIZZA_PINEAPPLE));


        Log.d("String of pizza name", pizza_name);

        Pizza pizza = new Pizza.PizzaMaker(pizza_name)
                .addCheese(pizza_cheese)
                .addChicken(pizza_chicken)
                .addChilli(pizza_chilli)
                .addMushroom(pizza_mushroom)
                .addPork(pizza_pork)
                .addPineapple(pizza_pineapple)
                .build();

        setTitle(pizza.getName());

        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.header, mPizzaDescription, false);

        mPizzaDescription.addHeaderView(header, null, false);
        mPizzaDescription.setAdapter(new ArrayAdapter<String>(getBaseContext(), R.layout.list_item, pizza.getIngredientsList()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
