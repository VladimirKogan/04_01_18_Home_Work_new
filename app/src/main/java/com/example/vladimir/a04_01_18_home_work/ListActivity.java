package com.example.vladimir.a04_01_18_home_work;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {
    private String[] loadList = new String[0];
    private String name, password, res, s;
    private Button add, logout, load;
    private TextView textView;
    private String new_name, new_phone, new_email, new_description;
    private Person p;
    private ListView myList;
    private MyAdapter adapter;
    SharedPreferences.Editor editor = new SharedPreferences.Editor() {
        @Override
        public SharedPreferences.Editor putString(String s, @Nullable String s1) {
            return null;
        }

        @Override
        public SharedPreferences.Editor putStringSet(String s, @Nullable Set<String> set) {
            return null;
        }

        @Override
        public SharedPreferences.Editor putInt(String s, int i) {
            return null;
        }

        @Override
        public SharedPreferences.Editor putLong(String s, long l) {
            return null;
        }

        @Override
        public SharedPreferences.Editor putFloat(String s, float v) {
            return null;
        }

        @Override
        public SharedPreferences.Editor putBoolean(String s, boolean b) {
            return null;
        }

        @Override
        public SharedPreferences.Editor remove(String s) {
            return null;
        }

        @Override
        public SharedPreferences.Editor clear() {
            return null;
        }

        @Override
        public boolean commit() {
            return false;
        }

        @Override
        public void apply() {

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Intent intent = getIntent();
        if(intent.getExtras() != null){
            name = intent.getExtras().getString("EMAIL");
            password = intent.getExtras().getString("PASS");
            res = name+password;
            Log.d("MY_TAG", res);
        }
        logout = findViewById(R.id.logout_btn);
        load = findViewById(R.id.load_btn);
        add = findViewById(R.id.add_btn);
        myList = findViewById(R.id.my_list);
        textView = findViewById(R.id.empty_list);
        adapter = new MyAdapter();

        logout.setOnClickListener(this);
        add.setOnClickListener(this);
        load.setOnClickListener(this);

        myList.setAdapter(adapter);
        load();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.logout_btn){
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.add_btn){
            Intent intent = new Intent(this, addActivity.class);
            startActivityForResult(intent, 1);
        }
        if(view.getId() == R.id.load_btn){
            load();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if (requestCode == 1){
                new_name = data.getExtras().getString("NAME");
                new_phone = data.getExtras().getString("PHONE");
                new_email = data.getExtras().getString("EMAIL");
                new_description = data.getExtras().getString("DESCRIPTION");

                p = new Person(new_name, new_phone, new_email, new_description);
                textView.setVisibility(View.GONE);
                adapter.addPerosn(p);
                save();
            }
        }
    }

    private void save(){
        SharedPreferences sharedPreferences = getSharedPreferences(res, MODE_PRIVATE);
        String string = sharedPreferences.getString(res, "");
        string += p.toString();
        editor = sharedPreferences.edit();
        editor.putString(res, string);
        editor.commit();
        Log.d("MY_TAG", "Saved!!!!");
    }
     private void load(){
        SharedPreferences sharedPreferences = getSharedPreferences(res, MODE_PRIVATE);
        Log.d("MY_TAG", "SHARED PREFERENCES");
        s = sharedPreferences.getString(res, "");
        Log.d("MY_TAG", s);
     }

     private void fillList(){
         if(!s.isEmpty()){
             loadList = s.split(";");
             for (int i = 0; i < loadList.length; i++) {
                 Log.d("MY_TAG", loadList[i]);
                 String[] innerString = loadList[i].split(",");
                 p.setName(innerString[0]);
                 p.setPhone(innerString[1]);
                 p.setEmail(innerString[2]);
                 p.setDescription(innerString[3]);
                 adapter.addPerosn(p);
             }
         }
     }
}
