package com.example.android.itcquizz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;

public class SplashActivity extends Activity {
    String userName;
    EditText name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lunch_screen);

        name = (EditText) findViewById(R.id.name_edit_text);
    }

    public void startQuiz(View view) {
        userName = name.getText().toString();
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        intent.putExtra("name", userName);
        startActivity(intent);
        // close this activity
        finish();
    }
}