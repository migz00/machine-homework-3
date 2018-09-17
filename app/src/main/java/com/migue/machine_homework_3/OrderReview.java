package com.migue.machine_homework_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OrderReview extends AppCompatActivity implements View.OnClickListener{

    TextView tv_flavor, tv_addons;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_review);

        getSupportActionBar().setTitle("Order Review Form");

        tv_flavor = findViewById(R.id.txt_flavor);
        tv_addons = findViewById(R.id.txt_addons);
        submit = findViewById(R.id.btn_send);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        tv_flavor.setText(extras.getString("flavor"));
        tv_addons.setText(extras.getString("addons"));

        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(), "Order has been submitted", Toast.LENGTH_SHORT).show();
        finish();
    }
}
