package com.example.cst438_proj1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cst438_proj1.data.User;
import com.example.cst438_proj1.data.UserDatabase;

public class LoginActivity extends AppCompatActivity {

    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private Button eRegister;
    private String Admin = "admin";
    private String aPassword = "12345";

    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eName = findViewById(R.id.etName);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.btnLogin);
        eRegister = findViewById(R.id.btnRegister);

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please enter all the details", Toast.LENGTH_SHORT).show();

                }else{
                    isValid = validate(inputName, inputPassword);
                    if(!isValid){
                        //Toast.makeText(MainActivity.this, "Incorrect credentials Entered", Toast.LENGTH_SHORT).show();
                        ePassword.setError("Invalid password");
                    }else{
                        //Add the code to go to new activity
//                        Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
//                        startActivity(intent);
                        nextActivity(v);
                    }
                }

            }
        });

        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(LoginActivity.this, CreateUserActivity.class);
              startActivity(intent);
            }
        });
    }

    private boolean validate(String name, String password){
        UserDatabase db = UserDatabase.getInMemoryDatabase(getApplicationContext());
        User user = db.getUserDAO().getUserByUsername(name);
        if(name.equals(user.getUserName()) && password.equals(user.getPassword())){
            return true;
        }
        return false;
    }

    public void nextActivity(View view){
        Intent intent = SearchJobs.getIntent(getApplicationContext(), "Welcome!! User");
        startActivity(intent);
    }

}