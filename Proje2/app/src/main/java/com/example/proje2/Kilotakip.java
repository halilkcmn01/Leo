package com.example.proje2;

import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class Kilotakip extends AppCompatActivity {
    private EditText boyText;
    private TextView textView10;
    private TextView idealText;
    private TextView boyTv;
    private SeekBar seekbar1;
    private TextView textView5;
    private RadioGroup radio;
    private boolean erkek=true;
    private  Double boy=0.0;
    private int kilo=45;
    private RadioGroup.OnCheckedChangeListener degistir3 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            if(checkedId==R.id.bay)
                erkek=true;
            else if (checkedId==R.id.bayan)
                erkek=false;
            guncelle();
        }
    };

    private SeekBar.OnSeekBarChangeListener degistir2 = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            kilo=30+progress;
            guncelle();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private TextWatcher degistir = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try {

                boy=Double.parseDouble(s.toString())/100.0;
            }catch (NumberFormatException e){

                boy=0.0;
            }
            guncelle();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kilotakip);
        boyText = (EditText) findViewById(R.id.boyText);
        textView10 =(TextView) findViewById(R.id.textView10);
        idealText =(TextView) findViewById(R.id.idealText);
        textView5 =(TextView) findViewById(R.id.textView5);
        boyTv =(TextView) findViewById(R.id.boyTv);
        radio = (RadioGroup) findViewById(R.id.radio);

        seekbar1=(SeekBar)findViewById(R.id.seekbar1);

        boyText.addTextChangedListener(degistir);
        seekbar1.setOnSeekBarChangeListener(degistir2);
        radio.setOnCheckedChangeListener(degistir3);


guncelle();



    }

    private void guncelle() {
        textView5.setText(String.valueOf(kilo)+" Kg");
        boyTv.setText(String.valueOf(boy)+" m");


        int idealkilobay= (int) (50+2.3*(boy*100*0.4-60));
        int idealkilobayan= (int) (45.5+2.3*(boy*100*0.4-60));

        double vkitle=kilo/(boy*boy);

        if (erkek){

            idealText.setText(String.valueOf(idealkilobay));
            if (vkitle<=20.7)
            {
                textView10.setBackgroundResource(R.color.zayif);
                textView10.setText(R.string.zayif);
            }else if (20.7<=vkitle && vkitle <=26.4)
            {
                textView10.setBackgroundResource(R.color.ideal);
                textView10.setText(R.string.ideal);
            }
            else if (26.4<=vkitle && vkitle <=27.8)
            {
                textView10.setBackgroundResource(R.color.normaldenfazla);
                textView10.setText(R.string.normaldenfazla);
            }
            else if (27.8<=vkitle && vkitle <=31.1)
            {
                textView10.setBackgroundResource(R.color.kilolu);
                textView10.setText(R.string.kilolu);
            }
            else if (31.1<=vkitle)
            {
                textView10.setBackgroundResource(R.color.obez);
                textView10.setText(R.string.obez);
            }
        }else
        { idealText.setText(String.valueOf(idealkilobayan));

            if (vkitle<=19.1)
            {
                textView10.setBackgroundResource(R.color.zayif);
                textView10.setText(R.string.zayif);
            }else if (19.1<=vkitle && vkitle <=25.8)
            {
                textView10.setBackgroundResource(R.color.ideal);
                textView10.setText(R.string.ideal);
            }
            else if (25.8<=vkitle && vkitle <=27.3)
            {
                textView10.setBackgroundResource(R.color.normaldenfazla);
                textView10.setText(R.string.normaldenfazla);
            }
            else if (27.3<=vkitle && vkitle <=32.3)
            {
                textView10.setBackgroundResource(R.color.kilolu);
                textView10.setText(R.string.kilolu);
            }
            else if (32.3<=vkitle)
            {
                textView10.setBackgroundResource(R.color.obez);
                textView10.setText(R.string.obez);
            }
        }
    }
}
