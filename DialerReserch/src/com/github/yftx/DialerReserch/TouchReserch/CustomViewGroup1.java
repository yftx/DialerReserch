package com.github.yftx.DialerReserch.TouchReserch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yftx on 6/15/14.
 */
public class CustomViewGroup1 extends ViewGroup {

    private int margin = 50;

    public CustomViewGroup1(Context context) {
        super(context);
    }

    public CustomViewGroup1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomViewGroup1(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            child.layout(l + margin, t + margin, r - margin, b - margin);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth = resolveSize(0, widthMeasureSpec);
        int measuredHeight = resolveSize(0, heightMeasureSpec);
        setMeasuredDimension(measuredWidth, measuredHeight);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

}
