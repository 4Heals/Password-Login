package com.example.pwlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPw extends AppCompatActivity {

    EditText edit3;
    Button enter;

    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_pw);

        SharedPreferences settings = getSharedPreferences("PREFS",0);
        password = settings.getString("password","");

        edit3 = (EditText) findViewById(R.id.edit3);
        enter = (Button) findViewById(R.id.enter);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edit3.getText().toString();

                if(text.equals(password)) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(EnterPw.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}