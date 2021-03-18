package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner inputTypeSpinner;
    EditText inputNumber;
    TextView resultCalc1, resultCalc2, resultCalc3, resultType1, resultType2, resultType3;
    ImageButton lengthButton, tempButton, weightButton;

    // Method for length conversion
    public void calculateLength(View view) {
        String strInput;
        Integer intInput;
        Double centimetre, foot, inch;

        // Get input number from EditText filled by user
        strInput = inputNumber.getText().toString();
        if (strInput.equals("")) {
            Toast.makeText(MainActivity.this, "Please enter a number.", Toast.LENGTH_SHORT).show();
            return;
        }
        intInput = Integer.parseInt(strInput);

        // Calculate Metre to Centimetre, Foot, Inch
        // cm = m * 100
        // ft = m * 3.281
        // in = m * 39.37
        centimetre = intInput * 100.0;
        foot = intInput * 3.281;
        inch = intInput * 39.37;

        // Display results
        resultCalc1.setText(String.format("%.2f", centimetre));
        resultCalc2.setText(String.format("%.2f", foot));
        resultCalc3.setText(String.format("%.2f", inch));
        resultType1.setText("Centimetre");
        resultType2.setText("Foot");
        resultType3.setText("Inch");
    }

    // Method for temperature conversion
    public void calculateTemp(View view) {
        String strInput;
        Integer intInput;
        Double fahrenheit, kelvin;

        // Read input from EditText filled by user and store it in variable input
        strInput = inputNumber.getText().toString();
        if (strInput.equals("")) {
            Toast.makeText(MainActivity.this, "Please enter a number.", Toast.LENGTH_SHORT).show();
            return;
        }
        intInput = Integer.parseInt(strInput);

        // Convert input temperature from C to F and K
        // F = (C * 9 / 5) + 32
        // K = C + 273.15
        fahrenheit = (intInput * 9.0 / 5) + 32;
        kelvin = intInput + 273.15;

        // Display results
        resultCalc1.setText(String.format("%.2f", fahrenheit));
        resultCalc2.setText(String.format("%.2f", kelvin));
        resultCalc3.setText("");
        resultType1.setText("Fahrenheit");
        resultType2.setText("Kelvin");
        resultType3.setText("");
    }

    // Method for weight conversion
    public void calculateWeight(View view) {
        String strInput;
        Integer intInput;
        Double gram, ounce, pound;

        // Read input from EditText filled by user and store it in variable input
        strInput = inputNumber.getText().toString();
        if (strInput.equals("")) {
            Toast.makeText(MainActivity.this, "Please enter a number.", Toast.LENGTH_SHORT).show();
            return;
        }
        intInput = Integer.parseInt(strInput);

        // Convert input weight from Kg to G, Ounce and Pound
        // gram = kilogram * 1000
        // ounce = kilogram * 35.274
        // pound = kilogram * 2.205
        gram = intInput * 1000.0;
        ounce = intInput * 35.274;
        pound = intInput * 2.205;

        // Display results
        resultCalc1.setText(String.format("%.2f", gram));
        resultCalc2.setText(String.format("%.2f", ounce));
        resultCalc3.setText(String.format("%.2f", pound));
        resultType1.setText("Gram");
        resultType2.setText("Ounce");
        resultType3.setText("Pound");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTypeSpinner = (Spinner)findViewById(R.id.typeSpinner);
        inputNumber = findViewById(R.id.editTextNumber);
        resultCalc1 = findViewById(R.id.calcResult1);
        resultCalc2 = findViewById(R.id.calcResult2);
        resultCalc3 = findViewById(R.id.calcResult3);
        resultType1 = findViewById(R.id.resultTextView1);
        resultType2 = findViewById(R.id.resultTextView2);
        resultType3 = findViewById(R.id.resultTextView3);
        lengthButton = (ImageButton)findViewById(R.id.lengthImageButton);
        tempButton = (ImageButton)findViewById(R.id.tempImageButton);
        weightButton = (ImageButton)findViewById(R.id.weightImageButton);

        // OnClickListener for Length Image Button
        lengthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the value of the selected item in inputTypeSpinner and store it in a variable
                String conversionType = inputTypeSpinner.getSelectedItem().toString();

                // If spinner selected item is "Metre", convert input. Else, show Toast error msg
                if (conversionType.equals("Metre")) {
                    calculateLength(v);
                }
                else {
                    Toast.makeText(MainActivity.this,
                            "Please select the correct conversion icon.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // OnClickListener for Temperature Image Button
        tempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the value of the selected item in inputTypeSpinner and store it in a variable
                String conversionType = inputTypeSpinner.getSelectedItem().toString();

                // Compare spinner selected item with "Celsius" string
                if (conversionType.equals("Celsius")) {
                    calculateTemp(v);
                }
                else {
                    Toast.makeText(MainActivity.this,
                            "Please select the correct conversion icon.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // OnClickListener for Weight Image Button
        weightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the value of the selected item in inputTypeSpinner and store it in a variable
                String conversionType = inputTypeSpinner.getSelectedItem().toString();

                // Compare spinner selected item with "Kilogram" string
                if (conversionType.equals("Kilogram")) {
                    calculateWeight(v);
                }
                else {
                    Toast.makeText(MainActivity.this,
                            "Please select the correct conversion icon.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}