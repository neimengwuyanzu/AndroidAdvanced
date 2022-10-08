package com.example.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CustomView extends View {

    private int lastX;
    private int lastY;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //获取手指触摸点的横竖坐标
        int x = (int) event.getX();//获取到手指触摸点距离控件的X距离
        int y = (int) event.getY();//获取到手指触摸点距离控件的y距离
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录摁下时候得坐标
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算移动的距离   X/Y为手指当前的坐标  lastX/Y 为手指摁下时候的坐标
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                //getLeft()     控件左边距离父布局左边的距离
                //getTop()      控件顶部距离父布局顶部的距离
                //getRight()    控件右边距离父布局左边的距离
                //getBottom()   控件底部距离父布局顶部的距离


                /**
                 * 假如摁下时候坐标为100，100
                 * 则 lastX/Y = 100，100
                 * 现在移动到了50.50
                 * offsetX = 50-100 = -50
                 * offsetY = 50-100 = -50
                 * getLeft()+offsetX getRight()+offsetX 重新绘制控件左右的位置
                 * getTop()+offsetY getBottom()+offsetY 重新绘制控件上下的位置
                 */
                //重新绘制控件位置 left top right bottom
//                layout(getLeft()+offsetX,getTop()+offsetY,
//                        getRight()+offsetX,getBottom()+offsetY);
                //偏移控件左右位置
//                offsetLeftAndRight(offsetX);
                //偏移控件上下位置
//                offsetTopAndBottom(offsetY);


                //这个也是移动控件的方法 但是用起来奇奇怪怪的
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft()+ offsetX;
                layoutParams.rightMargin = getRight()+ offsetX;
                layoutParams.topMargin = getTop()+ offsetY;
                layoutParams.bottomMargin = getBottom()+ offsetY;
                setLayoutParams(layoutParams);

                Log.d("zyzyzy", " X = " + x);
                Log.d("zyzyzy", " Y = " + y);
                Log.d("zyzyzy", " lastX = " + lastX);
                Log.d("zyzyzy", " lastY = " + lastY);
                Log.d("zyzyzy", " offsetX = " + offsetX);
                Log.d("zyzyzy", " offsetY = " + offsetY);
                break;

        }
        return true;
    }
}
