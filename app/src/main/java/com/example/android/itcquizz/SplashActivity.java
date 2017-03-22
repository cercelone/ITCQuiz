package com.example.android.itcquizz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        userName = name.getText().toString(); //holds the name enetred in editText by the user
        if (userName.equalsIgnoreCase(""))
            Toast.makeText(this, "Name should not be empty!", Toast.LENGTH_SHORT).show();
        else {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            intent.putExtra("name", userName); //it sends to the next MainActivity the variable name with its value
            startActivity(intent); // starts the MainACtivity
            finish(); // close this activity
        }
    }
}