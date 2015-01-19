package org.example.jt.pizzamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.HashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    public final String LOG_TAG = "MainActivity";
    public final static String PIZZA_NAME = "pizza_name";
    public final static String PIZZA_CHEESE = "pizza_cheese";
    public final static String PIZZA_CHICKEN = "pizza_chicken";
    public final static String PIZZA_CHILLI = "pizza_chilli";
    public final static String PIZZA_MUSHROOM = "pizza_mushroom";
    public final static String PIZZA_PORK = "pizza_pork";
    public final static String PIZZA_PINEAPPLE = "pizza_pineapple";

    private EditText mEdit_cheese;
    private EditText mEdit_chilli;
    private EditText mEdit_chicken;
    private EditText mEdit_mushroom;
    private EditText mEdit_pineapple;
    private EditText mEdit_pork;
    private EditText mEdit_name;

    private Button mButton_makePizza;

    private Spinner mCheeseSpinner;
    private Spinner mChickenSpinner;
    private Spinner mChilliSpinner;
    private Spinner mMushroomSpinner;
    private Spinner mPineappleSpinner;
    private Spinner mPorkSpinner;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        intent = new Intent(this, SecondActivity.class);

        mEdit_name = (EditText) findViewById(R.id.name_edit);

        mCheeseSpinner = (Spinner) findViewById(R.id.cheese_spinner);
        mChickenSpinner = (Spinner) findViewById(R.id.chicken_spinner);
        mChilliSpinner = (Spinner) findViewById(R.id.chilli_spinner);
        mMushroomSpinner = (Spinner) findViewById(R.id.mushroom_spinner);
        mPineappleSpinner = (Spinner) findViewById(R.id.pineapple_spinner);
        mPorkSpinner = (Spinner) findViewById(R.id.pork_spinner);

        mButton_makePizza = (Button) findViewById(R.id.make_pizza);

        mCheeseSpinner.setAdapter(ArrayAdapter.createFromResource(this, R.array.cheese_type, R.layout.support_simple_spinner_dropdown_item));
        mChickenSpinner.setAdapter(ArrayAdapter.createFromResource(this, R.array.chicken_type, R.layout.support_simple_spinner_dropdown_item));
        mChilliSpinner.setAdapter(ArrayAdapter.createFromResource(this, R.array.chilli_type, R.layout.support_simple_spinner_dropdown_item));
        mMushroomSpinner.setAdapter(ArrayAdapter.createFromResource(this, R.array.mushroom_type, R.layout.support_simple_spinner_dropdown_item));
        mPineappleSpinner.setAdapter(ArrayAdapter.createFromResource(this, R.array.pineapple_type, R.layout.support_simple_spinner_dropdown_item));
        mPorkSpinner.setAdapter(ArrayAdapter.createFromResource(this, R.array.pork_type, R.layout.support_simple_spinner_dropdown_item));

        mButton_makePizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra(PIZZA_NAME, mEdit_name.getText().toString());
                intent.putExtra(PIZZA_CHEESE, mCheeseSpinner.getSelectedItem().toString().toUpperCase().replace(" ", "_"));
                intent.putExtra(PIZZA_CHILLI, mChilliSpinner.getSelectedItem().toString().toUpperCase().replace(" ", "_"));
                intent.putExtra(PIZZA_CHICKEN, mChickenSpinner.getSelectedItem().toString().toUpperCase().replace(" ", "_"));
                intent.putExtra(PIZZA_MUSHROOM, mMushroomSpinner.getSelectedItem().toString().toUpperCase().replace(" ", "_"));
                intent.putExtra(PIZZA_PINEAPPLE, mPineappleSpinner.getSelectedItem().toString().toUpperCase().replace(" ", "_"));
                intent.putExtra(PIZZA_PORK, mPorkSpinner.getSelectedItem().toString().toUpperCase().replace(" ", "_"));
                startActivity(intent);

            }
        });
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
