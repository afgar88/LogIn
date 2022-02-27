package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Sign In");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);

        final EditText emailValidate = (EditText)findViewById(R.id.email);

        final TextView messageEmail = (TextView)findViewById(R.id.messageEmail);


        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        emailValidate .addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if (s.toString().matches(emailPattern))
                {
                   // Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
                    // or
                    messageEmail.setText("valid email");
                }
                else
                {
                    //Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();
                    //or
                    messageEmail.setText("invalid email");
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // other stuffs
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // other stuffs
            }
        });


    }

}