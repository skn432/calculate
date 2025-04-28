package com.example.exp11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    EditText etNum1, etNum2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(v -> calculate('+'));
        btnSub.setOnClickListener(v -> calculate('-'));
        btnMul.setOnClickListener(v -> calculate('*'));
        btnDiv.setOnClickListener(v -> calculate('/'));

    }

    private void calculate(char operator) {
        String input1 = etNum1.getText().toString();
        String input2 = etNum2.getText().toString();

        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(input1);
        double num2 = Double.parseDouble(input2);
        double result = 0;

        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/':
                if (num2 == 0) {
                    tvResult.setText("Error: Division by zero");
                    return;
                } else {
                    result = num1 / num2;
                }
                break;
        }

        tvResult.setText("Result: " + result);
    }

}