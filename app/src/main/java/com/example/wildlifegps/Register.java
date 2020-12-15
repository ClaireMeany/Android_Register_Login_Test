package com.example.wildlifegps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = Register.this;

    private EditText username;
    private EditText password;
    private EditText password2;


    private Button create_btn;
    private Button login_btn;

    private DBHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();
    }

    private void initViews(){
        username=(EditText) findViewById(R.id.username_create);
        password = (EditText) findViewById(R.id.password_create);
        password2 = (EditText) findViewById(R.id.password_confirm);

        login_btn = (Button) findViewById(R.id.login_redirect);
        create_btn= (Button) findViewById(R.id.create_account);
    }

    private void initListeners(){
        login_btn.setOnClickListener(this);
        create_btn.setOnClickListener(this);
    }

    private void initObjects(){
        db=new DBHandler(activity);
    }

    @Override
    public void onClick(View view){

        //if the create account button is pressed
        if(view.getId()==(R.id.create_account)){
            //validate fields are filled
            if(checkInput(username)&& checkInput(password)&&checkInput(password2)){
                //validate the passwords are the same
                if(password.getText().toString().trim().equals(password2.getText().toString())){
                    //check if username is taken
                    if(!db.searchUsername(username.getText().toString().trim())){

                        //add user
                        User user = new User(username.getText().toString().trim(), password.getText().toString().trim());
                        db.addUser(user);
                        finish();
                    }
                    //popup "username is already taken"
                    else{
                        Toast.makeText(activity, "Username taken", Toast.LENGTH_LONG).show();
                        username.setText(null);
                        password.setText(null);
                        password2.setText(null);
                    }
                }
                // popup "passwords did not match"
                else{
                    Toast.makeText(activity, "Passwords do not match", Toast.LENGTH_LONG).show();
                    username.setText(null);
                    password.setText(null);
                    password2.setText(null);
                }

            }

            //else popup "please fill in all fields"
            else{
                Toast.makeText(activity, "Fill in all fields", Toast.LENGTH_LONG).show();
                username.setText(null);
                password.setText(null);
                password2.setText(null);
            }
        }
        //if the log in button is pressed
        if(view.getId()==(R.id.login_redirect)){
            //go to login view
            Intent intentLogin = new Intent(getApplicationContext(), login.class);
            startActivity(intentLogin);
        }

    }

    private boolean checkInput(EditText text){
        String value = text.getText().toString().trim();
        if(value.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
}
