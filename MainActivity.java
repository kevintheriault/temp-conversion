package com.example.temperatureconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button convertTempButton;
    ToggleButton toggleCF;
    TextView tempInput, tempOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertTempButton = (Button)findViewById(R.id.button);
        tempInput = (TextView)findViewById(R.id.editTemperature);
        tempOutput = (TextView)findViewById(R.id.outputTemperature);
        toggleCF = (ToggleButton)findViewById(R.id.toggleButton);

        convertTempButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button){

            if(toggleCF.isChecked()){

                double celToFar = Double.parseDouble(tempInput.getText().toString())*(9.0/5)+32;

                tempOutput.setText(String.format("%5.1f", celToFar));

            }else{

                double farToCel = (Double.parseDouble(tempInput.getText().toString())-32)*(5.0/9);
                tempOutput.setText(String.format("%5.2f", farToCel));

            }
        }
    }

}