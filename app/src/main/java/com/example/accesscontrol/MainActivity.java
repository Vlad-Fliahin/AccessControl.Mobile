package com.example.accesscontrol;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void signUp(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.sign_up:
                intent = new Intent(this, SignUp.class);
                break;
            case R.id.submit:
                intent = new Intent(this, Home.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}