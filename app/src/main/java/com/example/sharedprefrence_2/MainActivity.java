package com.example.sharedprefrence_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText EdtEmail,EdtPassword;
    Button BtnLogin;

    private String SharedName = "LoginActivity";
    private static final String Key_pass = "Password";
    private static final String Key_mail= "mail";

    String correct_password = "gawade55";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EdtEmail = findViewById(R.id.EdtEmail);
        EdtPassword = findViewById(R.id.Edtpassword);
        BtnLogin = findViewById(R.id.BtnLogin);

        SharedPreferences sharedPreferences = getSharedPreferences(SharedName,MODE_PRIVATE);

        //When Open Activity First Check shared preference data available or not
        String mail=sharedPreferences.getString(Key_mail,null);
        if(mail != null){
            //if data is available then directly call on mainactivity2 .
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        }


        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(EdtPassword.getText().toString())){
                    Toast.makeText(MainActivity.this,"Data Provided Empty",Toast.LENGTH_LONG).show();
                }
                else{

                    if(EdtPassword.getText().toString().equals(correct_password)){
                        Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Invalid Password",Toast.LENGTH_LONG).show();
                    }
                }
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Key_mail,EdtEmail.getText().toString());
                editor.putString(Key_pass,EdtPassword.getText().toString().trim());
                editor.apply();
            }
        });
    }
}