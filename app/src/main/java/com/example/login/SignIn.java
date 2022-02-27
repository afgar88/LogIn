package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
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

        final TextView messagePasword = (TextView)findViewById(R.id.messagePassword);

        final EditText passwordValidate=(EditText)findViewById(R.id.password);

        Button btnSignIn = (Button)findViewById(R.id.BtnSignIn);
        btnSignIn.setEnabled(false);

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String passwordPattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!*^&+=])(.{8,})$";

        emailValidate .addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if (s.toString().matches(emailPattern))
                {
                    messageEmail.setText("Valid email");
                    btnSignIn.setEnabled(true);
                }
                else
                {
                    //Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();
                    //or
                    messageEmail.setText("Invalid email");
                    btnSignIn.setEnabled(false);
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });


        passwordValidate.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

                if (s.toString().matches(passwordPattern))
                {
                    messagePasword.setText("Valid Password");
                    btnSignIn.setEnabled(true);
                }
                else
                {
                    messagePasword.setText("Invalid Password");
                    btnSignIn.setEnabled(false);
                }

            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
        });


    }

}