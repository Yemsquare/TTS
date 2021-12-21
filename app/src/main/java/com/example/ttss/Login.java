package com.example.ttss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.widget.Toast;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private EditText txtusername, txtpassword;
    private ImageButton loginCTA;
    private TextView txtreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtusername = findViewById(R.id.usernametxt);
        txtpassword = findViewById(R.id.passwordtxt);
        loginCTA = findViewById(R.id.login);
        txtreg = findViewById(R.id.registerCTA);

       loginCTA.setOnClickListener(new View.OnClickListener(){

           public void onClick(View V){
               String user = txtusername.getText().toString();
               String password = txtpassword.getText().toString();

               if(TextUtils.isEmpty(user) && TextUtils.isEmpty(password)){
                   Toast.makeText(Login.this, "Please enter your username or password", Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(Login.this, "Successfully login ", Toast.LENGTH_SHORT).show();
                   Intent i = new Intent(Login.this, MainActivity4.class);
                   startActivity(i);
               }
           }
       });
       txtreg.setOnClickListener(new View.OnClickListener(){

           public void onClick(View V){
               Intent i = new Intent(Login.this, Registration.class);
               startActivity(i);
           }
       });
    }
}