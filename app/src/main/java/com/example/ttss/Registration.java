package com.example.ttss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;
 **/



public class Registration extends AppCompatActivity {

    private EditText txtuser, txtpassword, txtconfirmPassword;
    private ImageButton nextBtn;
    private TextView signtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        txtuser = findViewById(R.id.username);
        txtpassword = findViewById(R.id.password);
        txtconfirmPassword = findViewById(R.id.confirm_password);
        nextBtn = findViewById(R.id.signBtn);
        signtxt = findViewById(R.id.sign_in_text);
                
        nextBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                String userName = txtuser.getText().toString();
                String passWord = txtpassword.getText().toString();
                String conPassWord = txtconfirmPassword.getText().toString();

                if (TextUtils.isEmpty(userName) && TextUtils.isEmpty(passWord) && TextUtils.isEmpty(conPassWord)){
                    Toast.makeText(Registration.this, "Please input details to register", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Registration.this,"Registration Succefully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Registration.this, MainActivity4.class);
                    i.putExtra("username :", userName);
                    startActivity(i);
                }
            }
        });
        signtxt.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                Intent i = new Intent(Registration.this, Login.class);
                startActivity(i);
            }
        });
    }
   /** private void loginUser(String userName, String passWord, String conPassWord){
        if ()

        parseUser.logInInBackground(userName, passWord, conPassWord, (parseUser, e) -> {
            if (parseUser != null){
                Toast.makeText(this, "Registration Succefully", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Registration.this, MainActivity4.class);
                i.putExtra("username ", userName);
                startActivity(i);
            } else {
                parseUser.logout();
                Toast.makeText(Registration.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    **/
}