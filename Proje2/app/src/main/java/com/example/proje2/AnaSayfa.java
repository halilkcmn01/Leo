package com.example.proje2;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AnaSayfa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);


    }

    public void egzsayfa(View view) {
        Intent gec1 = new Intent(getApplicationContext(), Egzersiz.class);
        startActivity(gec1);
    }

    public void diyet(View view) {
        Intent gec2 = new Intent(getApplicationContext(), Diyet.class);
        startActivity(gec2);
    }

    public void kilo(View view) {
        Intent gec3 = new Intent(getApplicationContext(), Kilotakip.class);
        startActivity(gec3);
    }

    public void oyun(View view) {
        Intent gec4 = new Intent(getApplicationContext(), Oyun.class);
        startActivity(gec4);


    }
}
