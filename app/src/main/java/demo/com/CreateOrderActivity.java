package demo.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CreateOrderActivity extends AppCompatActivity {

    private TextView textViewOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        textViewOrder = findViewById(R.id.textViewOrder);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String password = intent.getStringExtra("password");

        String textOrder = "Привет " + name + ", ваш пароль: " + password;

        textViewOrder.setText(textOrder);
    }
}