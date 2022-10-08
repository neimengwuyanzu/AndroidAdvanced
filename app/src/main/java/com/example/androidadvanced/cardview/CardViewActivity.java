package com.example.androidadvanced.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;

import com.example.androidadvanced.R;

public class CardViewActivity extends AppCompatActivity {

    private CardView mCardView;
    private SeekBar sb1;
    private SeekBar sb2;
    private SeekBar sb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        assignViews();
    }

    private void assignViews() {
        mCardView = findViewById(R.id.tv_item);
        sb1 = findViewById(R.id.sb_1);
        sb2 = findViewById(R.id.sb_2);
        sb3 = findViewById(R.id.sb_3);
        //设置圆角
        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mCardView.setRadius(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //设置阴影
        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mCardView.setCardElevation(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //设置间距
        sb3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mCardView.setContentPadding(i,i,i,i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mCardView.setCardBackgroundColor(Color.parseColor("#FF00FF"));


    }
}