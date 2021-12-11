package com.example.multiply_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public double num29 = 0;
    public Context mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;
    }

    public void OpenAllNumbersActivity(View view) {
        startActivity(new Intent(this, AllNumbersActivity.class));
    }

    public void OpenSelectNumbersActivity(View view) {
        EditText editText29 = findViewById(R.id.Number29);
        String strNum29 = editText29.getText().toString();
        String patternNumber29 = "^(([2-8]{1}([.]{1}[0-9]+)?)|[9]{1})$";
        if (Pattern.matches(patternNumber29, strNum29)) {
            this.num29 = Double.parseDouble(strNum29);
            Intent intent = new Intent(this.mainActivity, SelectNumbersActivity.class);
            intent.putExtra("num29", this.num29);
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Введите число от 2 до 9", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}