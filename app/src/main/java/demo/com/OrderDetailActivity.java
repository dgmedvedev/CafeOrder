package demo.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        TextView textViewOrder = findViewById(R.id.textViewOrder);

        Intent intent = getIntent();
        if (intent.hasExtra("order")) {
            String order = intent.getStringExtra("order");
            textViewOrder.setText(order);
        } else {
            Intent backToLogin = new Intent(this, LoginActivity.class);
            startActivity(backToLogin);
        }
    }
}