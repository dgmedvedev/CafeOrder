package demo.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button buttonCreateOrder;
    private EditText editTextName;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonCreateOrder = findViewById(R.id.buttonCreateOrder);
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonCreateOrder.setOnClickListener(view -> {
            String name = editTextName.getText().toString().trim(); // trim() - без пробелов
            String password = editTextPassword.getText().toString().trim(); // trim() - без пробелов
            if (!name.isEmpty() && !password.isEmpty()) {
                Intent intent = new Intent(this, CreateOrderActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("password", password);
                startActivity(intent);
            } else {
                Toast.makeText(this, R.string.warning_fill_fields, Toast.LENGTH_SHORT).show();
            }
        });
    }
}