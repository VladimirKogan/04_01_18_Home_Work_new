package com.example.vladimir.a04_01_18_home_work;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addActivity extends AppCompatActivity implements View.OnClickListener {

    private Button addBtn, backBtn;
    EditText newName, newPhone, newEmail, newDescription;
    String newNameStr, newPhoneStr, newEmailStr, newDescriptionStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        addBtn = findViewById(R.id.add_btn);
        backBtn = findViewById(R.id.back_btn);
        newName = findViewById(R.id.name_input);
        newPhone = findViewById(R.id.phone_input);
        newEmail = findViewById(R.id.email_input);
        newDescription = findViewById(R.id.description_input);

        addBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.add_btn) {
            newNameStr = newName.getText().toString();
            newPhoneStr = newPhone.getText().toString();
            newEmailStr = newEmail.getText().toString();
            newDescriptionStr = newDescription.getText().toString();

            Intent data = new Intent();
            data.putExtra("NAME", newNameStr);
            data.putExtra("PHONE", newPhoneStr);
            data.putExtra("EMAIL", newEmailStr);
            data.putExtra("DESCRIPTION", newDescriptionStr);
            Log.d("MY_TAG", "backed");
            setResult(RESULT_OK, data);
            finish();
        }
        if(view.getId() == R.id.back_btn){
            setResult(RESULT_OK);
        }
    }
}
