package com.github.yftx.DialerReserch.TouchReserch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.github.yftx.DialerReserch.Utils.LogUtils;

/**
 * Created by yftx on 6/15/14.
 */
public class CustomView extends View {
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth = resolveSize(0, widthMeasureSpec);
        int measuredHeight = resolveSize(0, heightMeasureSpec);
        setMeasuredDimension(measuredWidth, measuredHeight);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean temp = super.dispatchTouchEvent(event);
        LogUtils.d("temp " + temp);
        return temp;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean temp = super.onTouchEvent(event);
        LogUtils.d("temp " + temp);
        return temp;
    }

}
