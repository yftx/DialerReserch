package com.github.yftx.DialerReserch.MergeAdapter.swipe;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.github.yftx.DialerReserch.R;
import com.github.yftx.DialerReserch.Utils.LogUtils;

/**
 * Created by yftx on 6/13/14.
 */
public class SwipeLayout extends FrameLayout implements SwipeHelper.SwipeHelperCallback {
    private SwipeHelper mSwipeHelper;
    private SwipeHelper.OnItemGestureListener mOnItemSwipeListener;

    public SwipeLayout(Context context) {
        super(context);
        final float densityScale = getResources().getDisplayMetrics().density;
        final float pagingTouchSlop = ViewConfiguration.get(context)
                .getScaledPagingTouchSlop();
        mSwipeHelper = new SwipeHelper(context, SwipeHelper.X, this,
                densityScale, pagingTouchSlop);
    }

    @Override
    public void addView(View view) {
        final FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
/*        params.setMarginsRelative(mCallLogPadding, mCallLogPadding, mCallLogPadding,
                mCallLogPadding);*/
        view.setLayoutParams(params);

        super.addView(view);
    }

    @Override
    public View getChildAtPosition(MotionEvent ev) {
        LogUtils.d(" child count " + getChildCount());
        return getChildCount() > 0 ? getChildAt(0) : null;
    }

    @Override
    public View getChildContentView(View v) {
        return v.findViewById(R.id.container);
    }

    @Override
    public void onScroll() {
    }

    @Override
    public boolean canChildBeDismissed(View v) {
        return true;
    }

    @Override
    public void onBeginDrag(View v) {
        // We do this so the underlying ScrollView knows that it won't get
        // the chance to intercept events anymore
        requestDisallowInterceptTouchEvent(true);
    }

    @Override
    public void onChildDismissed(View v) {
        if (v != null && mOnItemSwipeListener != null) {
            mOnItemSwipeListener.onSwipe(v);
        }
    }

    @Override
    public void onDragCancelled(View v) {
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        LogUtils.d("mSwipeHelper " + mSwipeHelper);
        if (mSwipeHelper != null) {
            return mSwipeHelper.onInterceptTouchEvent(ev) || super.onInterceptTouchEvent(ev);
        } else {
            return super.onInterceptTouchEvent(ev);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        LogUtils.d("mSwipeHelper " + mSwipeHelper);
        if (mSwipeHelper != null) {
            return mSwipeHelper.onTouchEvent(ev) || super.onTouchEvent(ev);
        } else {
            return super.onTouchEvent(ev);
        }
    }

    public void setOnItemSwipeListener(SwipeHelper.OnItemGestureListener listener) {
        mOnItemSwipeListener = listener;
    }
}
