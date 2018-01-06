package com.example.vladimir.a04_01_18_home_work;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private Button login;
    private EditText email, pass;
    String email_str, pass_str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email_login);
        pass = findViewById(R.id.pass_login);
        login = findViewById(R.id.login_btn);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.login_btn) {
            email_str = email.getText().toString();
            pass_str = pass.getText().toString();
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra("EMAIL", email_str);
            intent.putExtra("PASS", pass_str);
            Log.d("MY_TAG", "worked " + email_str + pass_str);
            startActivity(intent);
        }
    }
}
