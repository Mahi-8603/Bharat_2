package com.mahi.tempratureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText inputEditText;
    private RadioButton celsiusRadioButton, fahrenheitRadioButton;
    private Button convertButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputEditText);
        celsiusRadioButton = findViewById(R.id.celsiusRadioButton);
        fahrenheitRadioButton = findViewById(R.id.fahrenheitRadioButton);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    @SuppressLint("StringFormatInvalid")
    private void convertTemperature() {
        String input = inputEditText.getText().toString();
        if (!input.isEmpty()) {
            double temperature = Double.parseDouble(input);
            double result;
            if (celsiusRadioButton.isChecked()) {
                // Convert from Celsius to Fahrenheit
                result = temperature * 9 / 5 + 32;
                resultTextView.setText(getString(R.string.result_format, result, "Fahrenheit"));
            } else if (fahrenheitRadioButton.isChecked()) {
                // Convert from Fahrenheit to Celsius
                result = (temperature - 32) * 5 / 9;
                resultTextView.setText(getString(R.string.result_format, result, "Celsius"));
            }
        }
    }

}
