package com.example.accesscontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void signUp(View view) {
        Intent intent = null;
        if (view.getId() == R.id.sign_up) {
            intent = new Intent(this, Home.class);
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}