package com.migue.machine_homework_3;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private static final String TAG = "MainActivity";
    private RadioGroup flavorGroup = null;
    private CheckBox pineappleCheckbox = null;
    private CheckBox sausageCheckBox = null;
    private CheckBox baconCheckBox = null;
    private CheckBox pepperoniCheckBox = null;
    private CheckBox mozarellaCheckBox = null;
    private CheckBox onionCheckBox = null;
    private CheckBox hamCheckBox = null;
    private FloatingActionButton orderFab = null;
    String flavor = "";
    String addons = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Pizza Ordering App");

        flavorGroup = findViewById(R.id.rg_flavor);
        pineappleCheckbox = findViewById(R.id.cb_pineapple);
        sausageCheckBox = findViewById(R.id.cb_sausage);
        baconCheckBox = findViewById(R.id.cb_bacon);
        pepperoniCheckBox = findViewById(R.id.cb_pepperoni);
        mozarellaCheckBox = findViewById(R.id.cb_mozarella);
        onionCheckBox = findViewById(R.id.cb_onions);
        hamCheckBox = findViewById(R.id.cb_ham);
        orderFab = findViewById(R.id.fab);

        flavorGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.rb_hawaiian:
                        flavor = "Hawaiian";
                        break;
                    case R.id.rb_pepperoni:
                        flavor = "Pepperoni";
                        break;
                    case R.id.rb_meat:
                        flavor = "Meat Lover's";
                        break;
                    case R.id.rb_stuffed:
                        flavor = "Stuffed Crust";
                        break;
                }
            }
        });
        orderFab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (flavor == "") {
            Toast.makeText(getApplicationContext(), "Please choose a flavor", Toast.LENGTH_SHORT).show();
            return;
        }
        if (pineappleCheckbox.isChecked()) {
            addons = addons + "Pinapple\n";
        }
        if (sausageCheckBox.isChecked()) {
            addons = addons + "Sausage Bits\n";
        }
        if (baconCheckBox.isChecked()) {
            addons = addons + "Bacon\n";
        }
        if (pepperoniCheckBox.isChecked()) {
            addons = addons + "Pepperoni\n";
        }
        if (mozarellaCheckBox.isChecked()) {
            addons = addons + "Mozarella\n";
        }
        if (onionCheckBox.isChecked()) {
            addons = addons + "Onions\n";
        }
        if (hamCheckBox.isChecked()) {
            addons = addons + "Ham\n";
        }
        if (addons == "") {
            addons = "None";
        }
        Log.d(TAG, flavor);
        Log.d(TAG, addons);
        Bundle extras = new Bundle();
        extras.putString("flavor", flavor);
        extras.putString("addons", addons);
        Intent intent = new Intent(this, OrderReview.class);
        intent.putExtras(extras);
        startActivity(intent);
        addons = "";
    }
}

