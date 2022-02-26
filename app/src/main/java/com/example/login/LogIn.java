package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username= (TextView) findViewById(R.id.UserName);
        TextView password= (TextView) findViewById(R.id.password);
        Button loginbtn=(Button)  findViewById(R.id.LoginBtn);
        TextView textsignin=(TextView) findViewById(R.id.SignInText);


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
                if (username.getText().toString().equals("Holi")&&password.getText().toString().equals("Holi")){
                    Intent Myintent = new Intent(getBaseContext(),Content.class);
                    startActivity(Myintent);

                }else{
                    Toast.makeText(LogIn.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}