package com.example.android.itcquizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup1.setVisibility(View.VISIBLE);
    }

    private int calculateScore() {

        RadioButton firstQuestion = (RadioButton) findViewById(R.id.radioButton1_4);

        if (firstQuestion.isChecked()) {
            score = score + 10;
        }

        RadioButton secondQuestion = (RadioButton) findViewById(R.id.radioButton2_3);

        if (secondQuestion.isChecked()) {
            score = score + 10;
        }

        RadioButton thirdQuestion = (RadioButton) findViewById(R.id.radioButton3_1);

        if (thirdQuestion.isChecked()) {
            score = score + 10;
        }

        CheckBox fourthQuestion1 = (CheckBox) findViewById(R.id.checkBox4_1);
        CheckBox fourthQuestion2 = (CheckBox) findViewById(R.id.checkBox4_3);

        if (fourthQuestion1.isChecked() && fourthQuestion2.isChecked()) {
            score = score + 10;
        }

        CheckBox fifthQuestion1 = (CheckBox) findViewById(R.id.checkBox5_1);
        CheckBox fifthQuestion2 = (CheckBox) findViewById(R.id.checkBox5_3);

        if (fifthQuestion1.isChecked() && fifthQuestion2.isChecked()) {
            score = score + 10;
        }

        RadioButton sixthQuestion = (RadioButton) findViewById(R.id.radioButton6_2);

        if (sixthQuestion.isChecked()) {
            score = score + 10;
        }

        CheckBox seventhQuestion1 = (CheckBox) findViewById(R.id.checkBox7_1);
        CheckBox seventhQuestion2 = (CheckBox) findViewById(R.id.checkBox7_2);

        if (seventhQuestion1.isChecked() && seventhQuestion2.isChecked()) {
            score = score + 10;
        }

        CheckBox eightQuestion1 = (CheckBox) findViewById(R.id.checkBox8_1);
        CheckBox eightQuestion2 = (CheckBox) findViewById(R.id.checkBox8_3);
        CheckBox eightQuestion3 = (CheckBox) findViewById(R.id.checkBox8_4);

        if (eightQuestion1.isChecked() && eightQuestion2.isChecked() && eightQuestion3.isChecked()) {
            score = score + 10;
        }

        CheckBox ninthQuestion1 = (CheckBox) findViewById(R.id.checkBox9_1);
        CheckBox ninthQuestion2 = (CheckBox) findViewById(R.id.checkBox9_2);
        CheckBox ninthQuestion3 = (CheckBox) findViewById(R.id.checkBox9_3);

        if (ninthQuestion1.isChecked() && ninthQuestion2.isChecked() && ninthQuestion3.isChecked()) {
            score = score + 10;
        }

        RadioButton tenthQuestion = (RadioButton) findViewById(R.id.radioButton10_3);

        if (tenthQuestion.isChecked()) {
            score = score + 10;
        }

        return score;
    }

    public void submitScore(View view){
        calculateScore();
        Toast.makeText(this, "Your score is " + score, Toast.LENGTH_SHORT).show();
    }

    public void viewQuestionNo2(View view){
        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radioGroup2.setVisibility(View.VISIBLE);
        radioGroup1.setVisibility(View.GONE);
    }
}