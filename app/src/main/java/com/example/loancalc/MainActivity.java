package com.example.loancalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editPurchase = findViewById(R.id.editPurchase);
        EditText editDown = findViewById(R.id.editDown);
        EditText editIntRate = findViewById(R.id.editIntRate);
        EditText editLength = findViewById(R.id.editLength);
        Button button = findViewById(R.id.button);
        TextView textOutput = findViewById(R.id.textOutput);

        initToggleButton();
        setForEditing(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double price = Double.parseDouble(editPurchase.getText().toString());
                double down = Double.parseDouble(editDown.getText().toString());
                double rate = Double.parseDouble(editIntRate.getText().toString());
                double len = Double.parseDouble(editLength.getText().toString());

                double mr = rate/12;
                double pow = Math.pow(1+mr,-len);

                double total = price-down;
                double payment = mr * total / (1-(pow));

                textOutput.setText("The payment is $" +payment+"/month.");
            }
        });
    }


    private void initToggleButton(){
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setForEditing(toggleButton.isChecked());
            }
        });

    }

    private void setForEditing(boolean enabled){
//        EditText editPurchase = findViewById(R.id.editPurchase);
//        EditText editDown = findViewById(R.id.editDown);
//        EditText editIntRate = findViewById(R.id.editIntRate);
//        EditText editLength = findViewById(R.id.editLength);
//        Button button = findViewById(R.id.button);

//
//        editPurchase.setEnabled(enabled);
//        editDown.setEnabled(enabled);
//        editIntRate.setEnabled(enabled);
//        editLength.setEnabled(enabled);
//        button.setEnabled(enabled);

    }
}