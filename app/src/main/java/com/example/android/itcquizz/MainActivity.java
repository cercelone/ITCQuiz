package com.example.android.itcquizz;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score; //total score
    boolean clicked = false; //it becomes true if the FINISH button is pressed
    String name; //holds the name entered by the user in first screen

    CardView question1;
    CardView question2;
    CardView question3;
    CardView question4;
    CardView question5;
    CardView question6;
    CardView question7;
    CardView question8;
    CardView question9;
    CardView question10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent(); //
        name = i.getStringExtra("name"); //holds the name entered in first screen, to be displayed with the final score

        question1 = (CardView) findViewById(R.id.cardViewQuestion1);
        question2 = (CardView) findViewById(R.id.cardViewQuestion2);
        question3 = (CardView) findViewById(R.id.cardViewQuestion3);
        question4 = (CardView) findViewById(R.id.cardViewQuestion4);
        question5 = (CardView) findViewById(R.id.cardViewQuestion5);
        question6 = (CardView) findViewById(R.id.cardViewQuestion6);
        question7 = (CardView) findViewById(R.id.cardViewQuestion7);
        question8 = (CardView) findViewById(R.id.cardViewQuestion8);
        question9 = (CardView) findViewById(R.id.cardViewQuestion9);
        question10 = (CardView) findViewById(R.id.cardViewQuestion10);

        //at start all questions are invisible, except first question
        question2.setVisibility(View.GONE);
        question3.setVisibility(View.GONE);
        question4.setVisibility(View.GONE);
        question5.setVisibility(View.GONE);
        question6.setVisibility(View.GONE);
        question7.setVisibility(View.GONE);
        question8.setVisibility(View.GONE);
        question9.setVisibility(View.GONE);
        question10.setVisibility(View.GONE);

        Button submit = (Button) findViewById(R.id.finish_button);

        //if savedInstanceState is not null, values of the total score and clicked are loaded
        if (savedInstanceState != null) {
            clicked = savedInstanceState.getBoolean("isFinishClicked");
            score = savedInstanceState.getInt("totalScore");
            //if the Finish button was clicked before, it will stay disabled
            if (clicked) {
                submit.setEnabled(false);
                submit.setTextColor(Color.GRAY);
            }
        }
    }

    //Saves the values of score and clicked
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putInt("totalScore", score);
        savedInstanceState.putBoolean("isFinishClicked", clicked);

        super.onSaveInstanceState(savedInstanceState);
    }

    //prevents closing application on Back Button Press
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this, R.style.alertStyle)
                .setTitle(R.string.alertTitle)
                .setMessage(R.string.alertQuestion)
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.super.onBackPressed();
                    }
                }).create().show();
    }

    // This method checks the answer for the first question
    private void checkFirstQuestion() {
        RadioButton firstAnswer = (RadioButton) findViewById(R.id.radioButton1_1);
        RadioButton secondAnswer = (RadioButton) findViewById(R.id.radioButton1_2);
        RadioButton thirdAnswer = (RadioButton) findViewById(R.id.radioButton1_3);
        RadioButton fourthAnswer = (RadioButton) findViewById(R.id.radioButton1_4);

        //if wrong radiobuttons are pressed, they are coloured in red
        if (firstAnswer.isChecked())
            firstAnswer.setTextColor(Color.RED);
        if (secondAnswer.isChecked())
            secondAnswer.setTextColor(Color.RED);
        if (thirdAnswer.isChecked())
            thirdAnswer.setTextColor(Color.RED);
        if (fourthAnswer.isChecked()) {
            score = score + 10;
        }

        //the right answer is coloured in GREEN
        fourthAnswer.setTextColor(Color.GREEN);

        //the radio buttons are set inactive after pressing the FINISH button
        firstAnswer.setEnabled(false);
        secondAnswer.setEnabled(false);
        thirdAnswer.setEnabled(false);
        fourthAnswer.setEnabled(false);
    }

    // This method checks the answer for the second question
    private void checkSecondQuestion() {
        RadioButton firstAnswer = (RadioButton) findViewById(R.id.radioButton2_1);
        RadioButton secondAnswer = (RadioButton) findViewById(R.id.radioButton2_2);
        RadioButton thirdAnswer = (RadioButton) findViewById(R.id.radioButton2_3);
        RadioButton fourthAnswer = (RadioButton) findViewById(R.id.radioButton2_4);

        if (firstAnswer.isChecked())
            firstAnswer.setTextColor(Color.RED);
        if (secondAnswer.isChecked())
            secondAnswer.setTextColor(Color.RED);
        if (fourthAnswer.isChecked())
            fourthAnswer.setTextColor(Color.RED);

        if (thirdAnswer.isChecked()) {
            score = score + 10;
        }

        thirdAnswer.setTextColor(Color.GREEN);

        firstAnswer.setEnabled(false);
        secondAnswer.setEnabled(false);
        thirdAnswer.setEnabled(false);
        fourthAnswer.setEnabled(false);
    }

    // This method checks the answer for the tirtd question
    private void checkThirdQuestion() {
        RadioButton firstAnswer = (RadioButton) findViewById(R.id.radioButton3_1);
        RadioButton secondAnswer = (RadioButton) findViewById(R.id.radioButton3_2);
        RadioButton thirdAnswer = (RadioButton) findViewById(R.id.radioButton3_3);
        RadioButton fourthAnswer = (RadioButton) findViewById(R.id.radioButton3_4);

        if (firstAnswer.isChecked()) {
            score = score + 10;
        }
        if (secondAnswer.isChecked())
            secondAnswer.setTextColor(Color.RED);
        if (fourthAnswer.isChecked())
            fourthAnswer.setTextColor(Color.RED);

        if (thirdAnswer.isChecked()) {
            thirdAnswer.setTextColor(Color.RED);
        }

        firstAnswer.setTextColor(Color.GREEN);

        firstAnswer.setEnabled(false);
        secondAnswer.setEnabled(false);
        thirdAnswer.setEnabled(false);
        fourthAnswer.setEnabled(false);
    }

    // This method checks the answer for the fourth question
    private void checkFourthQuestion() {
        CheckBox fourthQuestion1 = (CheckBox) findViewById(R.id.checkBox4_1);
        CheckBox fourthQuestion3 = (CheckBox) findViewById(R.id.checkBox4_3);
        CheckBox fourthQuestion2 = (CheckBox) findViewById(R.id.checkBox4_2);
        CheckBox fourthQuestion4 = (CheckBox) findViewById(R.id.checkBox4_4);

        if (fourthQuestion1.isChecked() && fourthQuestion3.isChecked()) {
            score = score + 10;
        }

        if (fourthQuestion2.isChecked()) {
            fourthQuestion2.setTextColor(Color.RED);
        }

        if (fourthQuestion4.isChecked()) {
            fourthQuestion4.setTextColor(Color.RED);
        }

        fourthQuestion1.setTextColor(Color.GREEN);
        fourthQuestion3.setTextColor(Color.GREEN);

        fourthQuestion1.setEnabled(false);
        fourthQuestion2.setEnabled(false);
        fourthQuestion3.setEnabled(false);
        fourthQuestion4.setEnabled(false);
    }

    // This method checks the answer for the fifth question
    private void checkFifthQuestion() {

        EditText fifthQuestion = (EditText) findViewById(R.id.answerQuestion5);
        String answerFifthQuestion = fifthQuestion.getText().toString();

        if (answerFifthQuestion.equalsIgnoreCase("kb") || answerFifthQuestion.equalsIgnoreCase("mb") || answerFifthQuestion.equalsIgnoreCase("GB")) {
            score = score + 10;
            fifthQuestion.setTextColor(Color.GREEN);
        }
            else
            fifthQuestion.setTextColor(Color.RED);
    }

    // This method checks the answer for the sixth question
    private void checkSixthQuestion() {
        RadioButton firstAnswer = (RadioButton) findViewById(R.id.radioButton6_1);
        RadioButton secondAnswer = (RadioButton) findViewById(R.id.radioButton6_2);
        RadioButton thirdAnswer = (RadioButton) findViewById(R.id.radioButton6_3);
        RadioButton fourthAnswer = (RadioButton) findViewById(R.id.radioButton6_4);

        secondAnswer.setTextColor(Color.GREEN);
        if (firstAnswer.isChecked())
            firstAnswer.setTextColor(Color.RED);
        if (secondAnswer.isChecked())
            score = score + 10;
        if (thirdAnswer.isChecked())
            thirdAnswer.setTextColor(Color.RED);
        if (fourthAnswer.isChecked())
            fourthAnswer.setTextColor(Color.RED);

        firstAnswer.setEnabled(false);
        secondAnswer.setEnabled(false);
        thirdAnswer.setEnabled(false);
        fourthAnswer.setEnabled(false);
    }

    // This method checks the answer for the seventh question
    private void checkSeventhQuestion() {
        CheckBox seventhQuestion1 = (CheckBox) findViewById(R.id.checkBox7_1);
        CheckBox seventhQuestion2 = (CheckBox) findViewById(R.id.checkBox7_2);
        CheckBox seventhQuestion3 = (CheckBox) findViewById(R.id.checkBox7_3);
        CheckBox seventhQuestion4 = (CheckBox) findViewById(R.id.checkBox7_4);

        if (seventhQuestion1.isChecked() && seventhQuestion2.isChecked()) {
            score = score + 10;
        }

        if (seventhQuestion3.isChecked())
            seventhQuestion3.setTextColor(Color.RED);

        if (seventhQuestion4.isChecked())
            seventhQuestion4.setTextColor(Color.RED);

        seventhQuestion1.setTextColor(Color.GREEN);
        seventhQuestion2.setTextColor(Color.GREEN);

        seventhQuestion1.setEnabled(false);
        seventhQuestion2.setEnabled(false);
        seventhQuestion3.setEnabled(false);
        seventhQuestion4.setEnabled(false);
    }

    // This method checks the answer for the eight question
    private void checkEightQuestion() {
        CheckBox eightQuestion1 = (CheckBox) findViewById(R.id.checkBox8_1);
        CheckBox eightQuestion3 = (CheckBox) findViewById(R.id.checkBox8_3);
        CheckBox eightQuestion4 = (CheckBox) findViewById(R.id.checkBox8_4);
        CheckBox eightQuestion2 = (CheckBox) findViewById(R.id.checkBox8_2);

        if (eightQuestion1.isChecked() && eightQuestion3.isChecked() && eightQuestion4.isChecked()) {
            score = score + 10;
        }

        eightQuestion1.setTextColor(Color.GREEN);
        eightQuestion3.setTextColor(Color.GREEN);
        eightQuestion4.setTextColor(Color.GREEN);

        if (eightQuestion2.isChecked()) {
            eightQuestion2.setTextColor(Color.RED);
        }

        eightQuestion1.setEnabled(false);
        eightQuestion2.setEnabled(false);
        eightQuestion3.setEnabled(false);
        eightQuestion4.setEnabled(false);
    }

    // This method checks the answer for the ninth question
    private void checkNinthQuestion() {
        CheckBox ninthQuestion1 = (CheckBox) findViewById(R.id.checkBox9_1);
        CheckBox ninthQuestion2 = (CheckBox) findViewById(R.id.checkBox9_2);
        CheckBox ninthQuestion3 = (CheckBox) findViewById(R.id.checkBox9_3);
        CheckBox ninthQuestion4 = (CheckBox) findViewById(R.id.checkBox9_4);

        if (ninthQuestion1.isChecked() && ninthQuestion2.isChecked() && ninthQuestion3.isChecked()) {
            score = score + 10;
        }

        ninthQuestion1.setTextColor(Color.GREEN);
        ninthQuestion2.setTextColor(Color.GREEN);
        ninthQuestion3.setTextColor(Color.GREEN);

        if (ninthQuestion4.isChecked()) {
            ninthQuestion4.setTextColor(Color.RED);
        }

        ninthQuestion1.setEnabled(false);
        ninthQuestion2.setEnabled(false);
        ninthQuestion3.setEnabled(false);
        ninthQuestion4.setEnabled(false);
    }

    // This method checks the answer for the tenth question
    private void checkTenthQuestion() {
        RadioButton firstAnswer = (RadioButton) findViewById(R.id.radioButton10_1);
        RadioButton secondAnswer = (RadioButton) findViewById(R.id.radioButton10_2);
        RadioButton thirdAnswer = (RadioButton) findViewById(R.id.radioButton10_3);
        RadioButton fourthAnswer = (RadioButton) findViewById(R.id.radioButton10_4);

        thirdAnswer.setTextColor(Color.GREEN);

        if (thirdAnswer.isChecked())
            score = score + 10;
        if (firstAnswer.isChecked())
            firstAnswer.setTextColor(Color.RED);
        if (secondAnswer.isChecked())
            secondAnswer.setTextColor(Color.RED);
        if (fourthAnswer.isChecked())
            fourthAnswer.setTextColor(Color.RED);

        firstAnswer.setEnabled(false);
        secondAnswer.setEnabled(false);
        thirdAnswer.setEnabled(false);
        fourthAnswer.setEnabled(false);
    }

    // This method calculates and returns the total score
    private int calculateScore() {

        checkFirstQuestion();
        checkSecondQuestion();
        checkThirdQuestion();
        checkFourthQuestion();
        checkFifthQuestion();
        checkSixthQuestion();
        checkSeventhQuestion();
        checkEightQuestion();
        checkNinthQuestion();
        checkTenthQuestion();

        return score;
    }

    /**
     * This method is Called when the FINISH button is pressed.
     * it calculates the score for the Quiz by calling CalculateScore method
     * and displays the score with the Toast
     * It sets the clicked variable to true
     */
    public void submitScore(View view) {
        calculateScore();
        Toast.makeText(this, name + ", Your score is " + score + " out of 100.", Toast.LENGTH_LONG).show();
        Button submit = (Button) findViewById(R.id.finish_button);
        submit.setEnabled(false);
        submit.setTextColor(Color.GRAY);
        clicked = true;
    }

    /** next methods are for the Next and Previous buttons
     * that makes the next/previous question visible
     * and the current question invisible
     */

    public void showPreviousQuestion1(View view) {
        question1.setVisibility(View.VISIBLE);
        question2.setVisibility(View.GONE);
    }

    public void showNextQuestion2(View view) {
        question1.setVisibility(View.GONE);
        question2.setVisibility(View.VISIBLE);
    }

    public void showPreviousQuestion2(View view) {
        question2.setVisibility(View.VISIBLE);
        question3.setVisibility(View.GONE);
    }

    public void showNextQuestion3(View view) {
        question2.setVisibility(View.GONE);
        question3.setVisibility(View.VISIBLE);
    }

    public void showPreviousQuestion3(View view) {
        question3.setVisibility(View.VISIBLE);
        question4.setVisibility(View.GONE);
    }

    public void showNextQuestion4(View view) {
        question3.setVisibility(View.GONE);
        question4.setVisibility(View.VISIBLE);
    }

    public void showPreviousQuestion4(View view) {
        question4.setVisibility(View.VISIBLE);
        question5.setVisibility(View.GONE);
    }

    public void showNextQuestion5(View view) {
        question4.setVisibility(View.GONE);
        question5.setVisibility(View.VISIBLE);
    }

    public void showPreviousQuestion5(View view) {
        question5.setVisibility(View.VISIBLE);
        question6.setVisibility(View.GONE);
    }

    public void showNextQuestion6(View view) {
        question5.setVisibility(View.GONE);
        question6.setVisibility(View.VISIBLE);
    }

    public void showPreviousQuestion6(View view) {
        question6.setVisibility(View.VISIBLE);
        question7.setVisibility(View.GONE);
    }

    public void showNextQuestion7(View view) {
        question6.setVisibility(View.GONE);
        question7.setVisibility(View.VISIBLE);
    }

    public void showPreviousQuestion7(View view) {
        question7.setVisibility(View.VISIBLE);
        question8.setVisibility(View.GONE);
    }

    public void showNextQuestion8(View view) {
        question7.setVisibility(View.GONE);
        question8.setVisibility(View.VISIBLE);
    }

    public void showPreviousQuestion8(View view) {
        question8.setVisibility(View.VISIBLE);
        question9.setVisibility(View.GONE);
    }

    public void showNextQuestion9(View view) {
        question8.setVisibility(View.GONE);
        question9.setVisibility(View.VISIBLE);
    }

    public void showPreviousQuestion9(View view) {
        question9.setVisibility(View.VISIBLE);
        question10.setVisibility(View.GONE);
    }

    public void showNextQuestion10(View view) {
        question9.setVisibility(View.GONE);
        question10.setVisibility(View.VISIBLE);
    }
}