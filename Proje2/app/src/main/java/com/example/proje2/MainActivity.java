package com.example.proje2;

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


    public void git(View view) {
        Intent gec = new Intent(getApplicationContext(), AnaSayfa.class);
        startActivity(gec);
    }
}

