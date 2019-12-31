package com.example.proje2;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Oyun extends AppCompatActivity implements View.OnClickListener {

    private Button [][] buttons = new Button[3][3];
    private boolean oyuncu1 = true;
    private int macsayisi;
    private int oyuncu1puan,oyuncu2puan;
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun);
        textViewPlayer1 = findViewById(R.id.text_view_1);
        textViewPlayer2 = findViewById(R.id.text_view_2);
        for (int i=0 ; i<3;i++){
            for (int j=0;j<3;j++)
            {
                String buttonID= "button_"+i+j;
                int resID = getResources().getIdentifier(buttonID,"id",getPackageName());
                buttons[i][j]=findViewById(resID);
                buttons[i][j].setOnClickListener(this);

            }
            }
        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resetGame();
            }
        });
    }

    @Override
    public void onClick(View v) {

        if(!((Button)v).getText().toString().equals("")){
            return;
        }
        if (oyuncu1){
            ((Button)v).setText("X");
            ((Button)v).setBackgroundResource(R.drawable.muz);

        }else
        {
            ((Button)v).setText("O");
        ((Button)v).setBackgroundResource(R.drawable.elma);}

        macsayisi++;
        if (kazanan()){
            if (oyuncu1){
                oyuncu1Kazandi();
            }else
                oyuncu2Kazandi();
        }else if (macsayisi==9){
            draw();
        }else
            oyuncu1=!oyuncu1;
    }
    private boolean kazanan(){
        String[][] field = new  String[3][3];
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                field[i][j] = buttons[i][j].getText().toString();

            }
        }
        for (int i=0;i<3;i++){
            if (field[i][0].equals(field[i][1])
            && field[i][0].equals(field[i][2])
            && !field[i][0].equals("")){
                return true;
            }
        }
        for (int i=0;i<3;i++){
            if (field[0][i].equals(field[1][i])
                    &&field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")){
                return true;
            }
    }
        if (field[0][0].equals(field[1][1])
                &&field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            return true;
        }
        if (field[2][0].equals(field[1][1])
                &&field[0][2].equals(field[2][0])
                && !field[0][2].equals("")){
            return true;



}
        return false;
    }
    private void oyuncu1Kazandi(){
        oyuncu1puan++;
        Toast.makeText(this,"Oyuncu1 Kazandi !",Toast.LENGTH_SHORT).show();
        puanguncelle();
        sifirla();
    }
    private void  oyuncu2Kazandi(){
        oyuncu2puan++;
        Toast.makeText(this,"Oyuncu2 Kazandi !",Toast.LENGTH_SHORT).show();
        puanguncelle();
        sifirla();
    }
    private void  draw(){
        Toast.makeText(this,"BERABERE !",Toast.LENGTH_SHORT).show();
        sifirla();
    }

    private void puanguncelle() {

        textViewPlayer1.setText("Oyuncu 1 : "+oyuncu1puan);
        textViewPlayer2.setText("Oyuncu 2 : "+oyuncu2puan);
    }
    private void sifirla(){
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                buttons[i][j].setText("");
                buttons[i][j].setBackgroundResource(R.drawable.gri);
            }
        }
        macsayisi=0;
        oyuncu1=true;

    }
    private void resetGame(){
        oyuncu1puan=0;
        oyuncu2puan=0;
        puanguncelle();
        sifirla();
    }
}
