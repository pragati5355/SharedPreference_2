package com.example.sharedprefrence_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView TextEmail;
    Button BtnLogout;

    SharedPreferences sharedPreferences;

    private static final String Key_mail = "mail";
    private static final String sharedname = "loginS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextEmail = findViewById(R.id.Email);
        BtnLogout = findViewById(R.id.Logout);


        sharedPreferences = getSharedPreferences(sharedname,MODE_PRIVATE);

     //   String mail = sharedPreferences.getString(Key_mail,null);
        // So set the data on Text view
     //   TextEmail.setText("" + mail);


        String mail=sharedPreferences.getString(Key_mail,null);
        TextEmail.setText(""+mail);




        BtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(MainActivity2.this,"Logout Successfully",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}