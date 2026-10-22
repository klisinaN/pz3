package com.example.practic3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button buttonAdd, buttonSubtract, buttonDivide, buttonMultiply, buttonClean;
    private TextView operation, result;
    private EditText number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonClean = findViewById(R.id.buttonClean);
        operation = findViewById(R.id.operation);
        result = findViewById(R.id.result);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonClean.setOnClickListener(this);
    }
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.buttonClean) {
            number1.setText("");
            number2.setText("");
            operation.setText("");
            result.setText("");
            return;
        }


        String sNum1 = number1.getText().toString().trim();
        String sNum2 = number2.getText().toString().trim();
        if (sNum1.isEmpty() || sNum2.isEmpty()) {
            Toast.makeText(this, "Введите оба числа!", Toast.LENGTH_SHORT).show();
            return;
        }
        float num1 = Float.parseFloat(sNum1);
        float num2 = Float.parseFloat(sNum2);
        float res = 0;
        if (id == R.id.buttonAdd) {
            operation.setText("+");
            res = num1 + num2;
        } else if (id == R.id.buttonSubtract) {
            operation.setText("-");
            res = num1 - num2;
        } else if (id == R.id.buttonDivide) {
            operation.setText("/");
            if (num2 == 0) {
                Toast.makeText(this, "Деление на ноль невозможно!", Toast.LENGTH_SHORT).show();
                result.setText("Ошибка");
                return;
            }
            res = num1 / num2;
        } else if (id == R.id.buttonMultiply) {
            operation.setText("*");
            res = num1 * num2;
        }
        result.setText(String.valueOf(res));
    }
}