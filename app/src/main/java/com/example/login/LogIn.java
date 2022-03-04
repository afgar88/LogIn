package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    String shared="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView email= findViewById(R.id.logemail);
        TextView password= findViewById(R.id.password);
        Button loginbtn=findViewById(R.id.LoginBtn);
        TextView textsignin=findViewById(R.id.SignInText);
        SharedPreferences sp = getSharedPreferences("users", Context.MODE_PRIVATE);




        textsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Myintent = new Intent(getBaseContext(),SignIn.class);
                startActivity(Myintent);

            }
        });


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shared = sp.getString(email.getText().toString(), "");

                //Log.d("Email",email.getText().toString());
                //Log.d("Prueba",shared);
                //Log.d("Pasw",password.getText().toString());

                    if(!shared.isEmpty() && shared.equals(password.getText().toString())){
                        Intent Myintent = new Intent(getBaseContext(),Content.class);
                        startActivity(Myintent);
                    }else{
                        Toast.makeText(LogIn.this, "Email or password are incorrect", Toast.LENGTH_SHORT).show();
                    }

                }


        });

    }
}