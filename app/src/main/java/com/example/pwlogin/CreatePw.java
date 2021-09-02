package com.example.pwlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePw extends AppCompatActivity {

    EditText edit1,edit2;
    Button conf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pw);

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        conf = (Button) findViewById(R.id.conf);

        conf.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String entry = edit1.getText().toString();
                String reentry = edit2.getText().toString();

                if(entry.equals("") || reentry.equals("")){
                    Toast.makeText(CreatePw.this, "No Password Entered", Toast.LENGTH_SHORT).show();
                } else {
                    if(entry.equals(reentry)){
                        SharedPreferences settings = getSharedPreferences("PREFS",0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("password",entry);
                        editor.apply();

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(CreatePw.this, "Password doesn't match", Toast.LENGTH_SHORT).show();
                    }
                    }
                }

            });
        }
}