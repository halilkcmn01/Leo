package com.example.proje2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Diyet3 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diyet3);
        ListView lv= findViewById(R.id.liste1);
        final TextView textView = findViewById(R.id.metin);
        final String[]Ogunler = {"Sabah","Öğlen","Akşam"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Ogunler);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (id==0){
                    textView.setText(R.string.diyet3sabah);
                }else if(id==1){
                    textView.setText(R.string.diyet3oglen);
                }else if(id==2){
                    textView.setText(R.string.diyet3aksam);
                }


            }
        });




    }}
