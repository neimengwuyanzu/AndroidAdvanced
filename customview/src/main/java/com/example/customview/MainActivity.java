package com.example.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CustomView customView;
    private TitleBar titleBar;


    @SuppressLint("Recycle")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        customView = findViewById(R.id.custom);
//        customViewMove();
//        titleBar = findViewById(R.id.title_bar);
//        titleView();

        ListView listView1 = findViewById(R.id.list_one);
        ListView listView2 = findViewById(R.id.list_two);
        ListView listView3 = findViewById(R.id.list_three);
        ListView listView4 = findViewById(R.id.list_four);
        ListView listView5 = findViewById(R.id.list_five);
        ListView listView6 = findViewById(R.id.list_six);

        String[] str1 = {
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111"
        };
        String[] str2 = {
                "2222222222",
                "2222222222",
                "2222222222",
                "2222222222",
                "2222222222",
                "2222222222",
                "2222222222",
                "2222222222",
                "2222222222",
                "2222222222",
                "2222222222",
                "2222222222",
                "2222222222",
                "2222222222",
                "2222222222",
                "2222222222",
                "2222222222",
                "2222222222",
                "2222222222",
                "2222222222"
        };
        String[] str3 = {
                "3333333333",
                "3333333333",
                "3333333333",
                "3333333333",
                "3333333333",
                "3333333333",
                "3333333333",
                "3333333333",
                "3333333333",
                "3333333333",
                "3333333333",
                "3333333333",
                "3333333333",
                "3333333333",
                "3333333333",
                "3333333333",
                "3333333333",
                "3333333333",
                "3333333333",
                "3333333333"
        };
        String[] str4 = {
                "4444444444",
                "4444444444",
                "4444444444",
                "4444444444",
                "4444444444",
                "4444444444",
                "4444444444",
                "4444444444",
                "4444444444",
                "4444444444",
                "4444444444",
                "4444444444",
                "4444444444",
                "4444444444",
                "4444444444",
                "4444444444",
                "4444444444",
                "4444444444",
                "4444444444",
                "4444444444"
        };
        String[] str5 = {
                "5555555555",
                "5555555555",
                "5555555555",
                "5555555555",
                "5555555555",
                "5555555555",
                "5555555555",
                "5555555555",
                "5555555555",
                "5555555555",
                "5555555555",
                "5555555555",
                "5555555555",
                "5555555555",
                "5555555555",
                "5555555555",
                "5555555555",
                "5555555555",
                "5555555555",
                "5555555555"
        };
        String[] str6 = {
                "6666666666",
                "6666666666",
                "6666666666",
                "6666666666",
                "6666666666",
                "6666666666",
                "6666666666",
                "6666666666",
                "6666666666",
                "6666666666",
                "6666666666",
                "6666666666",
                "6666666666",
                "6666666666",
                "6666666666",
                "6666666666",
                "6666666666",
                "6666666666",
                "6666666666",
                "6666666666"
        };

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, str1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, str2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, str3);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, str4);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, str5);
        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, str6);

        listView1.setAdapter(adapter1);
        listView2.setAdapter(adapter2);
        listView3.setAdapter(adapter3);
        listView4.setAdapter(adapter4);
        listView5.setAdapter(adapter5);
        listView6.setAdapter(adapter6);


    }

    private void titleView() {
        titleBar.setTitle("甘霖良");
        titleBar.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
            }
        });
        titleBar.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void customViewMove() {

//        customView.smoothScrollTo(-400,0);
//        customView.setAnimation(AnimationUtils.loadAnimation(this,R.anim.translate));


        /**
         * translationX/Y           沿着X/Y轴 进行平移
         * rotation rotationXX/Y    用来围绕View的支点进行旋转
         * PrivotX/Y                控制view对象的支点位置 围绕这个支点进行旋转和缩放变换处理。默认该支点位置就是view对象的中心点
         * alpha                    透明度 从1（不透明）-0（透明）
         * x/y                      描述View对象在容器中的最终位置
         */
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(customView, "translationX", 0.0f, 200.0f, 0f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(customView, "scaleX", 1.0f, 2.0f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(customView, "rotationX", 0.0f, 90.0f, 0.0f);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(1000);
        /**
         * after（Animator anim）     将现有动画插入到传入的动画之后执行
         * after（long delay）        将现有动画延迟指定的毫秒后执行
         * before（Animator anim）    将现有动画插入到传入的动画之前执行
         * with（Animator anim）      将现有动画插入和传入的动画同时执行
         *
         * 先执行anim3  然后anim1 anim2一起执行
         * 先翻转  然后
         */
        set.play(animator1).with(animator2).after(animator3);
        set.start();
    }
}