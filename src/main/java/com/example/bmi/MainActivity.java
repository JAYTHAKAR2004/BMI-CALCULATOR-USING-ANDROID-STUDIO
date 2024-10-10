package com.example.bmi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtWeight, edtHeightFt, edtHeightIn;
    Button btnCalculate;
    TextView txtResult;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);

        // Set button click listener
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightStr = edtWeight.getText().toString();
                String heightFtStr = edtHeightFt.getText().toString();
                String heightInStr = edtHeightIn.getText().toString();

                // Validate inputs
                if (weightStr.isEmpty() || heightFtStr.isEmpty() || heightInStr.isEmpty()) {
                    txtResult.setText("Please fill all fields");
                    return;
                }

                int weight = Integer.parseInt(weightStr);
                int heightFt = Integer.parseInt(heightFtStr);
                int heightIn = Integer.parseInt(heightInStr);

                // Convert height to inches
                int totalInches = (heightFt * 12) + heightIn;

                // Convert height to meters
                double heightMeters = totalInches * 0.0254;

                // Calculate BMI
                double bmi = weight / (heightMeters * heightMeters);

                // Display result based on BMI value
                if (bmi > 25) {
                    txtResult.setText("You're Overweight");
                } else if (bmi < 18.5) {
                    txtResult.setText("You're Underweight");
                } else {
                    txtResult.setText("You're Healthy");
                }
            }
        });
    }
}
