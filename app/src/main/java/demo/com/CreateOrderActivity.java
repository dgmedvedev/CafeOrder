package demo.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class CreateOrderActivity extends AppCompatActivity {

    private TextView textViewAdditions;
    private CheckBox checkBoxMilk;
    private CheckBox checkBoxSugar;
    private CheckBox checkBoxLemon;
    private Spinner spinnerTea;
    private Spinner spinnerCoffee;


    private String drink;
    private String name;
    private String password;
    private String additions;
    private StringBuilder builderAdditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        Intent intent = getIntent();
        if (intent.hasExtra("name") && intent.hasExtra("password")) {
            name = intent.getStringExtra("name");
            password = intent.getStringExtra("password");
        } else {
            name = getString(R.string.default_name);
            password = getString(R.string.default_password);
        }
        TextView textViewHello = findViewById(R.id.textViewHello);
        String textHello = String.format(getString(R.string.hello_user), name);
        textViewHello.setText(textHello);

        drink = getString(R.string.tea);
        textViewAdditions = findViewById(R.id.textViewAdditions);
        additions = String.format(getString(R.string.additions), drink);
        textViewAdditions.setText(additions);
        checkBoxMilk = findViewById(R.id.checkBoxMilk);
        checkBoxSugar = findViewById(R.id.checkBoxSugar);
        checkBoxLemon = findViewById(R.id.checkBoxLemon);
        spinnerTea = findViewById(R.id.spinnerTea);
        spinnerCoffee = findViewById(R.id.spinnerCoffee);
        builderAdditions = new StringBuilder();
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        ImageView buttonSendOrder = findViewById(R.id.buttonSendOrder);

        radioGroup.setOnCheckedChangeListener((radioGr, id) -> {
            if (id == R.id.radioButtonTea) {
                drink = getString(R.string.tea);
                spinnerTea.setVisibility(View.VISIBLE);
                spinnerCoffee.setVisibility(View.INVISIBLE);
                checkBoxLemon.setVisibility(View.VISIBLE);
            } else {
                drink = getString(R.string.coffee);
                spinnerTea.setVisibility(View.INVISIBLE);
                spinnerCoffee.setVisibility(View.VISIBLE);
                checkBoxLemon.setVisibility(View.INVISIBLE);
            }
            additions = String.format(getString(R.string.additions), drink);
            textViewAdditions.setText(additions);
        });

        buttonSendOrder.setOnClickListener(view -> {
            builderAdditions.setLength(0);
            if (checkBoxMilk.isChecked()) {
                builderAdditions.append(getString(R.string.milk)).append(" ");
            }
            if (checkBoxSugar.isChecked()) {
                builderAdditions.append(getString(R.string.sugar)).append(" ");
            }
            if (checkBoxLemon.isChecked() && drink.equals(getString(R.string.tea))) {
                builderAdditions.append(getString(R.string.lemon));
            }
            String optionOfDrink = "";
            if (drink.equals(getString(R.string.tea))) {
                optionOfDrink = spinnerTea.getSelectedItem().toString();
            } else {
                optionOfDrink = spinnerCoffee.getSelectedItem().toString();
            }
            String order = String.format(getString(R.string.order),
                    name, password, drink, optionOfDrink);
            String additions;
            if (builderAdditions.length() > 0) {
                additions = getString(R.string.need_additions) + builderAdditions.toString();
            } else {
                additions = "";
            }
            String fullOrder = order + additions;
            Intent intentOrder = new Intent(this, OrderDetailActivity.class);
            intentOrder.putExtra("order", fullOrder);
            startActivity(intentOrder);
        });
    }
}