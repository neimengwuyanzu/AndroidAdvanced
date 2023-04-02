package com.example.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TitleBar extends RelativeLayout {

    private ImageView iv_title_left;
    private ImageView iv_title_right;
    private TextView tv_title_title;
    private RelativeLayout rl_title;
    private int mColor = Color.BLUE;
    private int mTextColor = Color.WHITE;
    private String titleName;


    public TitleBar(Context context) {
        super(context);
        initView(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs,R.styleable.TitleBar);
        mColor = mTypedArray.getColor(R.styleable.TitleBar_title_bg,Color.BLUE);
        mTextColor = mTypedArray.getColor(R.styleable.TitleBar_title_text_color,Color.WHITE);
        titleName = mTypedArray.getString(R.styleable.TitleBar_title_text);
        mTypedArray.recycle();
        initView(context);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.title_view,this,true);
        iv_title_left = findViewById(R.id.iv_title_left);
        iv_title_right = findViewById(R.id.iv_title_right);
        tv_title_title = findViewById(R.id.tv_title);
        rl_title = findViewById(R.id.rl_title);
        //设置背景颜色
        rl_title.setBackgroundColor(mColor);
        //设置标题字体颜色
        tv_title_title.setTextColor(mTextColor);
    }

    public void setTitle(String titleStr){
        if (!TextUtils.isEmpty(titleStr)){
            tv_title_title.setText(titleStr);
        }
    }

    public void setLeftListener(OnClickListener onClickListener){
        iv_title_left.setOnClickListener(onClickListener);
    }

    public void setRightListener(OnClickListener onClickListener){
        iv_title_right.setOnClickListener(onClickListener);
    }


}
