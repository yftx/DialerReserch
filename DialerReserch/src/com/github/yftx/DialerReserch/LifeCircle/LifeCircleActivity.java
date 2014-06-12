package com.github.yftx.DialerReserch.LifeCircle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import com.github.yftx.DialerReserch.R;
import com.github.yftx.DialerReserch.Utils.LogUtils;

/**
 * Created by yftx on 6/12/14.
 */
public class LifeCircleActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.d();
        setContentView(R.layout.life_circle_activity);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d();
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.d();
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.d();
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.d();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.d();
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        LogUtils.d();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtils.d();
    }
}