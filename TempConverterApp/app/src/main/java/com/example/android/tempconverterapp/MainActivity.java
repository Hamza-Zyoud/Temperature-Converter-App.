package com.example.android.tempconverterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText degreeValue;
    RadioButton toFehr;
    RadioButton toCelc;
    Button calcBtn;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        degreeValue = (EditText) findViewById(R.id.degreeVal);
        toFehr = (RadioButton) findViewById(R.id.Fehr);
        toCelc = (RadioButton) findViewById(R.id.Celc);
        calcBtn = (Button) findViewById(R.id.Calc);
        result =(TextView) findViewById(R.id.result);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = degreeValue.getText().toString();
                if(value.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Please enter a value",Toast.LENGTH_SHORT).show();
                }else{
                    double x = Double.parseDouble(value);
                    if(toCelc.isChecked()){
                        double res = (x - 32) * 5 /9;
                        result.setText(""+res+" Fehrenhiet");
                    }else if (toFehr.isChecked()){
                        double res = ((x * 9)/5)+32;
                        result.setText(""+res+" Celcius");
                    }
                }
            }
        });

    }
}
