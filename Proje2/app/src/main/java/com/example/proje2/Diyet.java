package com.example.proje2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Diyet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diyet);

    }
    public void sayfa1(View view) {
        Intent gec1 = new Intent(getApplicationContext(), Diyet2.class);
        startActivity(gec1);
    }
    public void sayfa2(View view) {
        Intent gec1 = new Intent(getApplicationContext(), Diyet1.class);
        startActivity(gec1);
    }
    public void sayfa3(View view) {
        Intent gec1 = new Intent(getApplicationContext(), Diyet3.class);
        startActivity(gec1);
    }
}
