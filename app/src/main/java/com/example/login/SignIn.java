package com.example.login;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    boolean email=false;
    boolean password=false;
    boolean confirmPas=false;
     private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Sign In");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);

         EditText emailValidate = (EditText)findViewById(R.id.email);
         TextView messageEmail = (TextView)findViewById(R.id.messageEmail);
         TextView messagePasword = (TextView)findViewById(R.id.messagePassword);
         EditText passwordValidate=(EditText)findViewById(R.id.password);
         EditText confirmPasword=(EditText)findViewById(R.id.confirmpassword);
         TextView messageConfirmPassword=(TextView)findViewById(R.id.messageConfirmPassword);
         btnSignIn=(Button)findViewById(R.id.BtnSignIn);


        btnSignIn.setEnabled(false);


        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String passwordPattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!*^&+=])(.{8,})$";



        emailValidate .addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if (s.toString().matches(emailPattern))
                {
                    messageEmail.setText("Valid email");
                    messageEmail.setTextColor(Color.parseColor("#10BC17"));
                    email=true;
                    validatefields();
                }
                else
                {
                    messageEmail.setText("Invalid Email");
                    emailValidate.setError("example@xxx.com");
                    messageEmail.setTextColor(Color.parseColor("#FF1503"));
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
                    messagePasword.setTextColor(Color.parseColor("#10BC17"));
                    password=true;
                    validatefields();
                }
                else
                {
                    messagePasword.setText("Invalid Password");
                    passwordValidate.setError("Your password should have a minimum of 8 characters and contain at least one number, one uppercase and one lower case letter");
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

        confirmPasword.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                Log.d("Password",passwordValidate.getText().toString());
                Log.d("Confirm",s.toString());
                if (s.toString().equals(passwordValidate.getText().toString()))
                {
                    messageConfirmPassword.setText("Mach");
                    messageConfirmPassword.setTextColor(Color.parseColor("#10BC17"));
                    confirmPas=true;
                    validatefields();

                }
                else
                {
                    messageConfirmPassword.setText("Password not mach");
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

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Myintent = new Intent(getBaseContext(),Content.class);
                startActivity(Myintent);
            }
        });


    }
    public void validatefields (){
        if (email==true && password==true && confirmPas==true){
            btnSignIn.setEnabled(true);
        }

    }

}