package com.example.multiply_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class AllNumbersActivity extends AppCompatActivity {

    public int round, a, b, correct;

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max + 1 - min)) + min);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_numbers);
        this.round = 1;
        this.correct = 0;
        TextView textView = findViewById(R.id.textView);
        this.a = getRandomNumber(1, 10);
        this.b = getRandomNumber(1, 10);
        String output = this.a + " * " + this.b + " = ?";
        textView.setText(output);
        TextView textView2 = findViewById(R.id.textView2);
        String questionNo = "Вопрос № " + this.round;
        textView2.setText(questionNo);
        Button button = findViewById(R.id.button);
        button.setText("Ответить");
    }

    public void Answer(View view) {
        Button button = findViewById(R.id.button);
        if (button.getText() == "Ответить") {
            TextView textView = findViewById(R.id.textView);
            TextView textView2 = findViewById(R.id.textView2);
            EditText editTextAnswer = findViewById(R.id.Answer);
            if (this.round < 20) {
                String strAnswer = editTextAnswer.getText().toString();
                String patternNumber = "^([0-9]{1,3})$";
                if (Pattern.matches(patternNumber, strAnswer)) {
                    int answer = Integer.parseInt(strAnswer);
                    if (this.a * this.b == answer) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Правильно!", Toast.LENGTH_LONG);
                        toast.show();
                        this.correct++;
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Неправильно.", Toast.LENGTH_LONG);
                        toast.show();
                    }
                    editTextAnswer.setText("");
                    this.a = getRandomNumber(1, 10);
                    this.b = getRandomNumber(1, 10);
                    String output = this.a + " * " + this.b + " = ?";
                    textView.setText(output);
                    this.round++;
                    String questionNo = "Вопрос № " + this.round;
                    textView2.setText(questionNo);
                }
            } else {
                String result = "Правильных ответов: " + ((double) this.correct / (double) (this.round - 1)) * 100.0 + "%";
                textView.setText(result);
                textView2.setText("Тест завершен");
                editTextAnswer.setText("");
                button.setText("Назад");
            }
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}